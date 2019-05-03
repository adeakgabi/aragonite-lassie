package com.greenfoxacademy.lassie.comment;

import com.greenfoxacademy.lassie.user.ApplicationUser;
import com.greenfoxacademy.lassie.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
  private CommentRepository commentRepository;
  private UserRepository userRepository;
  
  @Autowired
  
  public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
    this.commentRepository = commentRepository;
    this.userRepository = userRepository;
  }
  
  public Comment saveComment(Comment comment){
    return commentRepository.save(comment);
  }
  
  public Comment postComment(CommentDto commentDto, Authentication auth){
    ApplicationUser user = userRepository.findByUsername(auth.getPrincipal().toString());
    Comment newComment = new Comment(commentDto.getMessage());
    newComment.setApplicationUser(user);
    return commentRepository.save(newComment);
  }
}
