package com.edplanes.fmgc.commons.events;

import io.vavr.control.Either;

public class EitherResults {
  public static <L, R> Either<L, R> left(L left) {
    return left(left);
  }

  public static <L, R> Either<L, R> right(R right) {
    return right(right);
  }
}
