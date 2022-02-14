package com.springboot.nelioalves.exceptions;

import javax.servlet.http.HttpServletRequest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ServiceObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ServiceObjectNotFoundException ex, HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Not found",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler(ServiceDataIntegrityViolationException.class)
  public ResponseEntity<StandardError> dataIntegrityViolation(ServiceDataIntegrityViolationException ex,
      HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        "Data Integrity Violation",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

  @ExceptionHandler({ ServiceIllegalArgumentException.class })
  public ResponseEntity<StandardError> illegalArgument(ServiceIllegalArgumentException ex,
      HttpServletRequest request) {

    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        "Illegal Argument",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

  @ExceptionHandler({ MethodArgumentNotValidException.class })
  public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpServletRequest request) {

    ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
        "field validation erro", ex.getMessage(), request.getRequestURI());

    for (FieldError field : ex.getBindingResult().getFieldErrors()) {
      err.addError(field.getField(), field.getDefaultMessage());
    }
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
  }

  @ExceptionHandler(ServiceAuthorizationException.class)
  public ResponseEntity<StandardError> authorizationException(ServiceAuthorizationException ex,
      HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
        "Access Denied",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
  }

  @ExceptionHandler(ServiceFileException.class)
  public ResponseEntity<StandardError> file(ServiceFileException ex, HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        "File error",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

  @ExceptionHandler(AmazonServiceException.class)
  public ResponseEntity<StandardError> amazonService(AmazonServiceException ex, HttpServletRequest request) {
    HttpStatus httpStatus = HttpStatus.valueOf(ex.getErrorCode());
    StandardError err = new StandardError(System.currentTimeMillis(), httpStatus.value(),
        "Error Amazon Service",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(httpStatus).body(err);
  }

  @ExceptionHandler(AmazonClientException.class)
  public ResponseEntity<StandardError> amazonClient(AmazonClientException ex, HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        "Error Amazon Client",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

  @ExceptionHandler(AmazonS3Exception.class)
  public ResponseEntity<StandardError> amazonClient(AmazonS3Exception ex, HttpServletRequest request) {
    StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
        "Error Amazon S3",
        ex.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }

}
