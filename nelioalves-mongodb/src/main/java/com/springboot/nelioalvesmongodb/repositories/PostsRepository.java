package com.springboot.nelioalvesmongodb.repositories;

import java.util.List;

import com.springboot.nelioalvesmongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);
}
