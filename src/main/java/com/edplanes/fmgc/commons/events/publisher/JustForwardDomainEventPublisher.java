package com.edplanes.fmgc.commons.events.publisher;

import org.springframework.context.ApplicationEventPublisher;

import com.edplanes.fmgc.commons.events.DomainEvent;
import com.edplanes.fmgc.commons.events.DomainEvents;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JustForwardDomainEventPublisher implements DomainEvents {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void publish(DomainEvent event) {
    applicationEventPublisher.publishEvent(event);
  }
}
