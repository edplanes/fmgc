package com.edplanes.fmgc.commons.events.publisher;

import com.edplanes.fmgc.commons.events.DomainEvent;
import com.edplanes.fmgc.commons.events.DomainEvents;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MeteredDomainEventPublisher implements DomainEvents {

  private static final String DOMAIN_EVENTS = "domain_events";
  private static final String TAG_NAME = "name";

  private final DomainEvents delegate;
  private final MeterRegistry metricsRegistry;

  public void publish(DomainEvent event) {
    delegate.publish(event);
    metricsRegistry.counter(DOMAIN_EVENTS, TAG_NAME, event.getClass().getSimpleName()).increment();
  }
}
