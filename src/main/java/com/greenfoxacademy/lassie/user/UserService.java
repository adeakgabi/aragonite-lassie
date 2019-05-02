package com.greenfoxacademy.lassie.user;

import com.greenfoxacademy.lassie.exception.ExistingUsernameException;
import com.greenfoxacademy.lassie.exception.MissingParameterException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

  ApplicationUser saveUser(ApplicationUser user)
          throws ExistingUsernameException, MissingParameterException;

  ResponseEntity registerNewUser(ApplicationUser user) throws MissingParameterException, ExistingUsernameException;

  List<ApplicationUser> getAllUser();
}
