package com.greenfoxacademy.lassie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.userRepository = userRepository;
  }

  public ApplicationUser registerNewUser(ApplicationUser user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return user;
  }

  public List<ApplicationUser> getAllUser() {
    List<ApplicationUser> users = new ArrayList<>(userRepository.findAll());
    return users;
  }
}
