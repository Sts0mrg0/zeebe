/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.processor;

import io.zeebe.protocol.record.value.ErrorType;
import java.util.Objects;

/** Simple String wrapper for when something fails and a message needs to be used. */
public final class Failure {

  private final String message;

  private final ErrorType errorType;

  public Failure(final String message) {
    this.message = message;
    errorType = null;
  }

  public Failure(final String message, final ErrorType errorType) {
    this.message = message;
    this.errorType = errorType;
  }

  public String getMessage() {
    return message;
  }

  public ErrorType getErrorType() {
    return errorType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Failure failure = (Failure) o;
    return Objects.equals(message, failure.message);
  }

  @Override
  public String toString() {
    return message;
  }
}
