package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exceptions.PostException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

  Post savePost(Post post) throws PostException;

  List<Post> getAllFoundAnimalPosts();

  List<Post> getAllLostAnimalPosts();
}
