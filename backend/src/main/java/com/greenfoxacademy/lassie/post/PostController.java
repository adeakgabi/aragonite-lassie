package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exception.PostException;
import com.greenfoxacademy.lassie.post.subtypes.Found;
import com.greenfoxacademy.lassie.post.subtypes.Lost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post/found/list")
  public ResponseEntity listFoundAnimalPosts() {
    return new ResponseEntity<>(postService.getAllFoundAnimalPosts(), HttpStatus.OK);
  }

  @GetMapping("/post/lost/list")
  public ResponseEntity listLostAnimalPosts() {
    return new ResponseEntity<>(postService.getAllLostAnimalPosts(), HttpStatus.OK);
  }

  @PostMapping("/post/found/create")
  public ResponseEntity createFoundAnimalPost(@RequestBody Found found, Authentication auth)
          throws PostException {
    return new ResponseEntity<>(postService.savePost(found, auth), HttpStatus.ACCEPTED);
  }

  @PostMapping("/post/lost/create")
  public ResponseEntity createLostAnimalPost(@RequestBody Lost lost, Authentication auth)
          throws PostException {
    return new ResponseEntity<>(postService.savePost(lost, auth), HttpStatus.ACCEPTED);
  }
}
