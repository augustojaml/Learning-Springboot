package com.springboot.nelioalvesmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.dto.UserDTO;
import com.springboot.nelioalvesmongodb.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
    User user = this.usersService.fromDTO(userDTO);
    user = this.usersService.insert(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable String id) {
    this.usersService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
    User user = this.usersService.fromDTO(userDTO);
    user.setId(id);
    user = this.usersService.update(user);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findPostByUser(@PathVariable String id) {
    User user = this.usersService.findById(id);
    return ResponseEntity.ok().body(user.getPosts());
  }
}
