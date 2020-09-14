package com.spring.data.mongodb.crudex.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex,
      WebRequest req) {
    ErrorMessage msg = new ErrorMessage(
      HttpStatus.NOT_FOUND.value(), 
      new Date(), 
      ex.getMessage(),
      req.getDescription(false));

    return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest req) {
    ErrorMessage msg = new ErrorMessage(
      HttpStatus.INTERNAL_SERVER_ERROR.value(), 
      new Date(), 
      ex.getMessage(),
      req.getDescription(false));

    return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
