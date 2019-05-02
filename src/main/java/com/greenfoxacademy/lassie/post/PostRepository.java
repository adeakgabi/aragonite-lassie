package com.greenfoxacademy.lassie.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

  @Query("SELECT p FROM Post p WHERE TYPE(p) = :postType")
  List<Post> findAllByDtype(@Param("postType") String postType);
}
