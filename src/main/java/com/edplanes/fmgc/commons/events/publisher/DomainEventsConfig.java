package com.edplanes.fmgc.commons.events.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edplanes.fmgc.commons.events.DomainEvents;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class DomainEventsConfig {

  @Bean
  DomainEvents domainEvents(ApplicationEventPublisher applicationEventPublisher, MeterRegistry metricsRegistry) {
    return new MeteredDomainEventPublisher(new JustForwardDomainEventPublisher(applicationEventPublisher),
        metricsRegistry);
  }
}
