package com.springboot.nelioalves.exceptions;

public class ServiceAuthorizationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ServiceAuthorizationException(String message) {
    super(message);
  }

  public ServiceAuthorizationException(String message, Throwable cause) {
    super(message, cause);
  }

}
