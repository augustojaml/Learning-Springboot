package com.springboot.nelioalvesmongodb.services;

import java.util.Date;
import java.util.List;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.repositories.PostsRepository;
import com.springboot.nelioalvesmongodb.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

  @Autowired
  PostsRepository postsRepository;

  public Post findById(String id) {
    return postsRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found"));
  }

  public List<Post> findByTitleContaining(String text) {
    return postsRepository.searchTitle(text);
  }

  public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
    maxDate = new Date(maxDate.getTime() + 24 + 60 + 60 * 1000);
    return postsRepository.fullSearch(text, minDate, maxDate);
  }

}
