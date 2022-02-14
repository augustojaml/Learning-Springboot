package com.springboot.nelioalvesmongodb.resources;

import java.util.List;

import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  UsersService usersService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<User>> findAll() {
    List<User> users = this.usersService.findAll();
    return ResponseEntity.ok().body(users);
  }
}
