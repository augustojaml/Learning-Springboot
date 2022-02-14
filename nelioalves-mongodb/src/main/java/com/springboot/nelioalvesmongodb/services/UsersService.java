package com.springboot.nelioalvesmongodb.services;

import java.util.List;

import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.dto.UserDTO;
import com.springboot.nelioalvesmongodb.repositories.UsersRepository;
import com.springboot.nelioalvesmongodb.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  UsersRepository usersRepository;

  public List<User> findAll() {
    return this.usersRepository.findAll();
  }

  public User findById(String id) {
    return usersRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
  }

  public User insert(User user) {
    return usersRepository.insert(user);
  }

  public User fromDTO(UserDTO userDTO) {
    return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
  }
}
