package com.greenfoxacademy.lassie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(ExistingUsernameException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ErrorMessage existingUsername(ExistingUsernameException ex) {
    return new ErrorMessage(ex.getMessage());
  }
}

