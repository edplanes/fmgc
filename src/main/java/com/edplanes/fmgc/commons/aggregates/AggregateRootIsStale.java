package com.edplanes.fmgc.commons.aggregates;

public class AggregateRootIsStale extends RuntimeException {
  public AggregateRootIsStale(String message) {
    super(message);
  }
}
