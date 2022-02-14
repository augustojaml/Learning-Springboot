package com.springboot.nelioalvesmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.dto.AuthorDTO;
import com.springboot.nelioalvesmongodb.repositories.PostsRepository;
import com.springboot.nelioalvesmongodb.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PostsRepository postsRepository;

  @Override
  public void run(String... args) throws Exception {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

    usersRepository.deleteAll();
    postsRepository.deleteAll();

    // CREATE USERS
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    // SAVE USERS
    usersRepository.saveAll(Arrays.asList(maria, alex, bob));

    // CREATE POSTS
    Post post1 = new Post(null, simpleDateFormat.parse("12/02/2022"), "Partiu viagem",
        "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
    Post post2 = new Post(null, simpleDateFormat.parse("13/02/2022"), "Bom dia",
        "Acordei feliz hoje", new AuthorDTO(maria));

    // SAVE POSTS
    postsRepository.saveAll(Arrays.asList(post1, post2));

  }

}
