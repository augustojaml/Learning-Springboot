package com.springboot.nelioalves.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ServiceObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ServiceObjectNotFoundException ex, HttpServletRequest request) {

    StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler(ServiceDataIntegrityViolationException.class)
  public ResponseEntity<StandardError> dataIntegrityViolation(ServiceDataIntegrityViolationException ex,
      HttpServletRequest request) {

    StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler({ ServiceIllegalArgumentException.class })
  public ResponseEntity<StandardError> illegalArgument(ServiceIllegalArgumentException ex,
      HttpServletRequest request) {

    StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

}
