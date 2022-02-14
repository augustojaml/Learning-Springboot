package com.springboot.nelioalvesmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.springboot.nelioalvesmongodb.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    User jose = new User("1", "Jose Mont", "jose@gmail.com");
    User maria = new User("1", "Maria Mont", "maria@gmail.com");
    List<User> users = new ArrayList<>();
    users.addAll(Arrays.asList(jose, maria));
    return ResponseEntity.ok().body(users);
  }
}
