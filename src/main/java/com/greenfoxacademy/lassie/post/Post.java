package com.greenfoxacademy.lassie.post;

import com.greenfoxacademy.lassie.comment.Comment;
import com.greenfoxacademy.lassie.user.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String description;
  private Timestamp postCreationTime;
  private String locationCoordinates;
  private String animalType;
  private String photo;
  @ManyToOne
  private ApplicationUser applicationUser;
  @OneToMany(mappedBy = "post", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  private List<Comment> comments;
  
  public void addComment(Comment comment){
    comments.add(comment);
  }
}
