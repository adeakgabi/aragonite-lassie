package com.greenfoxacademy.lassie.comment;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
  private CommentRepository commentRepository;
  
  @Autowired
  
  public CommentServiceImpl(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }
}
