package com.greenfoxacademy.lassie.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage {
  private String message;
  private String status;

  public ErrorMessage(String message) {
    this.status = "error";
    this.message = message;
  }
}

