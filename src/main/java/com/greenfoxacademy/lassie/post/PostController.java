package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exceptions.PostException;
import com.greenfoxacademy.lassie.post.subtypes.Found;
import com.greenfoxacademy.lassie.post.subtypes.Lost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/post")
public class PostController {

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/found/list")
  public ResponseEntity listFoundAnimalPosts(){
    return new ResponseEntity<>(postService.getAllFoundAnimalPosts(), HttpStatus.OK);
  }

  @GetMapping("/lost/list")
  public ResponseEntity listLostAnimalPosts(){
    return new ResponseEntity<>(postService.getAllLostAnimalPosts(), HttpStatus.OK);
  }

  @PostMapping("/found/create")
  public ResponseEntity createFoundAnimalPost(@RequestBody Found found)
          throws PostException {
    return new ResponseEntity<>(postService.savePost(found), HttpStatus.ACCEPTED);
  }

  @PostMapping("/lost/create")
  public ResponseEntity createLostAnimalPost(@RequestBody Lost lost)
          throws PostException {
    return new ResponseEntity<>(postService.savePost(lost), HttpStatus.ACCEPTED);
  }
}
