package com.greenfoxacademy.lassie.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

  ApplicationUser findByUsername(String username);

  List<ApplicationUser> findAll();
}
