package com.edplanes.fmgc.commons.events.publisher;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import com.edplanes.fmgc.commons.events.DomainEvent;
import com.edplanes.fmgc.commons.events.DomainEvents;

import io.vavr.collection.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoreAndForwardDomainEventsPublisher implements DomainEvents {

  private final DomainEvents eventsPublisher;
  private final EventsStorage eventsStorage;

  public void publish(DomainEvent event) {
    eventsPublisher.publish(event);
    eventsStorage.store(event);
  }

  @Scheduled(fixedRateString = "${events.publisher.store-and-forward.interval: #{3000L}}")
  @Transactional
  public void publishStoredEventsPeriodically() {
    List<DomainEvent> events = eventsStorage.getToPublish();
    events.forEach(eventsPublisher::publish);
    eventsStorage.markAsPublished(events);
  }
}
