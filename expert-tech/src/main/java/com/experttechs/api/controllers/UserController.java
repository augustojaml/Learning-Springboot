package com.experttechs.api.controllers;

import java.util.List;
import java.util.Optional;

import com.experttechs.api.models.UserModel;
import com.experttechs.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder encoder;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserModel>> findlAll() {
    List<UserModel> users = this.userRepository.findAll();
    return ResponseEntity.ok().body(users);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<UserModel> save(@RequestBody UserModel user) {
    user.setPassword(encoder.encode(user.getPassword()));
    user = userRepository.save(user);
    return ResponseEntity.ok().body(user);
  }

  @RequestMapping(value = "/validatePassword", method = RequestMethod.GET)
  public ResponseEntity<Boolean> validatePassword(@RequestParam String login, @RequestParam String password) {

    Optional<UserModel> user = userRepository.findByLogin(login);
    if (user.isEmpty()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

    boolean valid = this.encoder.matches(password, user.get().getPassword());
    HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

    return ResponseEntity.status(status).body(valid);
  }
}
