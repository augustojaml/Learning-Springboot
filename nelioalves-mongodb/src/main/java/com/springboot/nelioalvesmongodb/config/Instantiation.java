package com.springboot.nelioalvesmongodb.config;

import java.util.Arrays;

import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public void run(String... args) throws Exception {

    usersRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    usersRepository.saveAll(Arrays.asList(maria, alex, bob));

  }

}
