package com.springboot.nelioalves.exceptions;

public class ServiceIllegalArgumentException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ServiceIllegalArgumentException(String message) {
    super(message);
  }

  public ServiceIllegalArgumentException(String message, Throwable cause) {
    super(message, cause);
  }

}
