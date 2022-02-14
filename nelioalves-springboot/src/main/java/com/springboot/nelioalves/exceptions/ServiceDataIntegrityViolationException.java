package com.springboot.nelioalves.exceptions;

public class ServiceDataIntegrityViolationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ServiceDataIntegrityViolationException(String message) {
    super(message);
  }

  public ServiceDataIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }

}
