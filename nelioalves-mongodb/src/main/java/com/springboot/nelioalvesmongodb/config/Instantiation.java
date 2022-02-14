package com.springboot.nelioalvesmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.domain.User;
import com.springboot.nelioalvesmongodb.dto.AuthorDTO;
import com.springboot.nelioalvesmongodb.dto.CommentDTO;
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
    Post post01 = new Post(null, simpleDateFormat.parse("12/02/2022"), "Partiu viagem",
        "Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
    Post post02 = new Post(null, simpleDateFormat.parse("13/02/2022"), "Bom dia",
        "Acordei feliz hoje", new AuthorDTO(maria));

    // CREATE COMMENTS
    CommentDTO comment01 = new CommentDTO("Boa Viagem mano!", simpleDateFormat.parse("14/02/2022"),
        new AuthorDTO(alex));
    CommentDTO comment02 = new CommentDTO("Aproveite", simpleDateFormat.parse("15/02/2022"), new AuthorDTO(bob));
    CommentDTO comment03 = new CommentDTO("Aproveite", simpleDateFormat.parse("16/02/2022"), new AuthorDTO(alex));

    // ADD COMMENTS FROM POST
    post01.getComments().addAll(Arrays.asList(comment01, comment02));
    post02.getComments().addAll(Arrays.asList(comment03));

    // SAVE POSTS
    postsRepository.saveAll(Arrays.asList(post01, post02));

    // ADD POST (MARIA)
    maria.getPosts().addAll(Arrays.asList(post01, post02));

    // SAVE POST MARIA
    usersRepository.save(maria);

  }

}
