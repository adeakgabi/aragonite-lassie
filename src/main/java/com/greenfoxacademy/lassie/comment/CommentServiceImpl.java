package com.greenfoxacademy.lassie.comment;

import com.greenfoxacademy.lassie.post.Post;
import com.greenfoxacademy.lassie.post.PostRepository;
import com.greenfoxacademy.lassie.user.ApplicationUser;
import com.greenfoxacademy.lassie.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
  private CommentRepository commentRepository;
  private UserRepository userRepository;
  private PostRepository postRepository;
  
  @Autowired
  
  public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
    this.commentRepository = commentRepository;
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }
  
  public Comment saveComment(Comment comment){
    return commentRepository.save(comment);
  }
  
  @Override
  public Comment postComment(CommentDto commentDto, Authentication auth, long id){
    ApplicationUser user = userRepository.findByUsername(auth.getPrincipal().toString());
    Post post = postRepository.findById(id);
    System.out.println(post.getAnimalType());
    Comment newComment = new Comment(commentDto.getMessage());
    newComment.setApplicationUser(user);
    newComment.setPost(post);
    return commentRepository.save(newComment);
  }
}
