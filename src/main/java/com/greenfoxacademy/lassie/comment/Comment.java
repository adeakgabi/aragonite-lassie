package com.greenfoxacademy.lassie.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.lassie.post.Post;
import com.greenfoxacademy.lassie.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String message;
  @ManyToOne
  @JsonIgnore
  private ApplicationUser applicationUser;
  @ManyToOne
  @JsonIgnore
  private Post post;
  
  
  public Comment(String message){
    this.message = message;
  }
  
  public void setApplicationUser(ApplicationUser applicationUser){
    this.applicationUser = applicationUser;
    applicationUser.addComment(this);
  }
  
  public void setPost(Post post){
    this.post = post;
    post.addComment(this);
  }
}
