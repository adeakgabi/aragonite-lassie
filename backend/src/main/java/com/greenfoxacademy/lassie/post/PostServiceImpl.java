package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.exception.PostException;
import com.greenfoxacademy.lassie.user.ApplicationUser;
import com.greenfoxacademy.lassie.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Post> getAllFoundAnimalPosts(){
    return postRepository.findAllFoundTypePosts();
  }

  @Override
  public List<Post> getAllLostAnimalPosts(){
    return postRepository.findAllLostTypePosts();
  }

  @Override
  public Post savePost(Post post, Authentication auth) throws PostException {
    if (post != null) {
      ApplicationUser applicationUser = userRepository.findByUsername(auth.getPrincipal().toString());
      if (applicationUser != null) {
        post.setApplicationUser(applicationUser);
        return postRepository.save(post);
      }
    }
    throw new PostException("Invalid post!");
  }
}
