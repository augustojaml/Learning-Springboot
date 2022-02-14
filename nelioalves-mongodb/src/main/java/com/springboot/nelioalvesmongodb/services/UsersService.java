package com.springboot.nelioalvesmongodb.services;

import java.util.List;

import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  UsersRepository usersRepository;

  public List<User> findAll() {
    return this.usersRepository.findAll();
  }
}
