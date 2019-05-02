package com.greenfoxacademy.lassie.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
  private CommentRepository commentRepository;
  
  @Autowired
  
  public CommentServiceImpl(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }
  
  public Comment saveComment(Comment comment){
    return commentRepository.save(comment);
  }
}
