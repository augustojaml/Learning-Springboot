package com.springboot.nelioalvesmongodb.repositories;

import java.util.List;

import com.springboot.nelioalvesmongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);

  @Query("{'title': {$regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);
}
