package com.greenfoxacademy.lassie.user;

import com.greenfoxacademy.lassie.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ApplicationUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String username;
  private String password;
  @OneToMany
  private List<Comment> comments;

  public ApplicationUser(String username, String password){
    this.username = username;
    this.password = password;
    this.comments = new ArrayList<>();
  }
  
  public void addComment(Comment comment){
    comments.add(comment);
  }
}
