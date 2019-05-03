package com.greenfoxacademy.lassie.comment;

import org.springframework.security.core.Authentication;

public interface CommentService {
  
  Comment saveComment(Comment comment);
  
  Comment postComment(CommentDto commentDto, Authentication auth, long id);
}
