package com.mservice.orders.rest.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class NoOrderException extends Throwable {

  public NoOrderException(String s) {
    super(s);
  }
}
