package com.greenfoxacademy.lassie.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
  
  private CommentService commentService;
  
  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }
  
  @PostMapping("/comment/{id}")
  public ResponseEntity postComment(@RequestBody CommentDto commentDto, Authentication auth, @PathVariable long id){
    return ResponseEntity.ok(commentService.postComment(commentDto, auth, id));
  }

}
