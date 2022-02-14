package com.springboot.nelioalvesmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.dto.UserDTO;
import com.springboot.nelioalvesmongodb.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  UsersService usersService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> users = this.usersService.findAll();
    List<UserDTO> usersDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    return ResponseEntity.ok().body(usersDTO);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User user = this.usersService.findById(id);
    UserDTO userDTO = new UserDTO(user);
    return ResponseEntity.ok().body(userDTO);
  }
}
