package com.greenfoxacademy.lassie.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  
  @PostMapping("/comment")
  public ResponseEntity postComment(@RequestBody CommentDto commentDto){
    Comment newComment = new Comment(commentDto.getMessage());
    commentService.saveComment(newComment);
    return ResponseEntity.ok("Comment is saved");
  }
}
