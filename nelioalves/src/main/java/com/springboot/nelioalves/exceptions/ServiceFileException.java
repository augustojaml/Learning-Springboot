package com.springboot.nelioalves.exceptions;

public class ServiceFileException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ServiceFileException(String msg) {
    super(msg);
  }

  public ServiceFileException(String msg, Throwable cause) {
    super(msg, cause);
  }

}