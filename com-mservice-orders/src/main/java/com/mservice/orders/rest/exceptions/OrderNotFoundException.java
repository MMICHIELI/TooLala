package com.mservice.orders.rest.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class OrderNotFoundException extends Throwable {

  public OrderNotFoundException(String s) {
    super(s);
  }
}
