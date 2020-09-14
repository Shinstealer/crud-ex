package com.spring.data.mongodb.crudex.exception;

public class ResourceNotFoundException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = -4567687551L;

  public ResourceNotFoundException(String msg) {
    super(msg);
  }

}
