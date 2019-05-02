package com.greenfoxacademy.lassie.user;

import java.util.List;

public interface UserService {

  ApplicationUser registerNewUser(ApplicationUser user);

  List<ApplicationUser> getAllUser();
}
