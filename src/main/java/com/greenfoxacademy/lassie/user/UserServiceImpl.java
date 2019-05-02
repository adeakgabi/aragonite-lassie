package com.greenfoxacademy.lassie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    userRepository.save(user);
    return user;
  }
}
