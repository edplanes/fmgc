package com.edplanes.fmgc.commons.events;

import java.time.Instant;
import java.util.UUID;

public interface DomainEvent {
  UUID getEventID();

  UUID getAggregateID();

  Instant getWhen();
}
