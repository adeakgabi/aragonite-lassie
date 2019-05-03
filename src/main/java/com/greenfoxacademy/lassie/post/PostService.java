package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exception.PostException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

  Post savePost(Post post, Authentication auth) throws PostException;

  List<Post> getAllFoundAnimalPosts();

  List<Post> getAllLostAnimalPosts();
}
