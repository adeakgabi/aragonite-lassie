package com.greenfoxacademy.lassie.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
  private String message;
  
  public String getMessage(){
    return this.message;
  }
}
