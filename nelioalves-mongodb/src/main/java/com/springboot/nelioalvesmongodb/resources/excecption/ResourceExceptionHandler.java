package com.springboot.nelioalvesmongodb.resources.excecption;

import javax.servlet.http.HttpServletRequest;

import com.springboot.nelioalvesmongodb.services.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError error = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", ex.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(status).body(error);
  }
}
