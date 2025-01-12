package com.edplanes.fmgc.commons.events.publisher;

import com.edplanes.fmgc.commons.events.DomainEvent;

import io.vavr.collection.List;

public interface EventsStorage {

  void store(DomainEvent event);

  List<DomainEvent> getToPublish();

  void markAsPublished(List<DomainEvent> events);
}
