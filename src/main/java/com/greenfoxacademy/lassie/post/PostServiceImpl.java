package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exceptions.PostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllFoundAnimalPosts(){
    return postRepository.findAllByDtype("Found");
  }

  @Override
  public List<Post> getAllLostAnimalPosts(){
    return postRepository.findAllByDtype("Lost");
  }

  @Override
  public Post savePost(Post post) throws PostException {
    if (post != null) {
      return postRepository.save(post);
    }
    throw new PostException("Invalid post!");
  }
}
