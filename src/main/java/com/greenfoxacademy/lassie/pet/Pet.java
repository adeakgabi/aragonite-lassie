package com.greenfoxacademy.lassie.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

  private long id;
  private Timestamp timestamp;
  private String locationCoordinates;
  private String species;
  private String description;

  @OneToOne
  //private ApplicationUser applicationUser;
  private String photo;
}
