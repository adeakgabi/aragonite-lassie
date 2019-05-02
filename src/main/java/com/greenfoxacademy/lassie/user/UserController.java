package com.greenfoxacademy.lassie.user;

import com.greenfoxacademy.lassie.exception.ExistingUsernameException;
import com.greenfoxacademy.lassie.exception.MissingParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity registerUser(@RequestBody ApplicationUser applicationUser)
          throws MissingParameterException, ExistingUsernameException {
    return userService.registerNewUser(applicationUser);
  }

  @GetMapping("/users")
  public List<ApplicationUser> showAllUsersDetails() {
    return new ArrayList<>(userService.getAllUser());
  }
}
