package com.greenfoxacademy.lassie.user;

import com.greenfoxacademy.lassie.exception.ExistingUsernameException;
import com.greenfoxacademy.lassie.exception.MissingParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

  public boolean checkIfValid(ApplicationUser user) throws MissingParameterException {
    boolean missingUserName = user.getUsername() == null || user.getUsername().length() == 0;
    boolean missingPassword = user.getPassword() == null || user.getPassword().length() == 0;
    if (missingUserName && missingPassword) {
      throw new MissingParameterException("Missing parameter(s): username, password");
    } else if (missingUserName) {
      throw new MissingParameterException("Missing parameter(s): username!");
    } else if (missingPassword) {
      throw new MissingParameterException("Missing parameter(s): password!");
    }
    return true;
  }

  public ApplicationUser saveUser(ApplicationUser user)
          throws ExistingUsernameException, MissingParameterException {
    if (userRepository.findByUsername(user.getUsername()) == null && checkIfValid(user)) {
      return userRepository.save(user);
    }
    throw new ExistingUsernameException("Username already taken, please choose another one.");
  }

  public ResponseEntity registerNewUser(ApplicationUser user) throws MissingParameterException, ExistingUsernameException {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    saveUser(user);
    return ResponseEntity.accepted().body(user);
  }

  public List<ApplicationUser> getAllUser() {
    List<ApplicationUser> users = new ArrayList<>(userRepository.findAll());
    return users;
  }

  @RequestMapping(value="/upload", method= RequestMethod.POST)
  public @ResponseBody String handleFileUpload(
          @RequestParam("file") MultipartFile file){
    String name = "test11";
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
        stream.write(bytes);
        stream.close();
        return "You successfully uploaded " + name + " into " + name + "-uploaded !";
      } catch (Exception e) {
        return "You failed to upload " + name + " => " + e.getMessage();
      }
    } else {
      return "You failed to upload " + name + " because the file was empty.";
    }
  }
}
