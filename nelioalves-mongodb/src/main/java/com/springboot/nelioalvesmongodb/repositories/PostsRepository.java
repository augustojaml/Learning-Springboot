package com.springboot.nelioalvesmongodb.repositories;

import java.util.Date;
import java.util.List;

import com.springboot.nelioalvesmongodb.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);

  @Query("{ 'title': {$regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);

  @Query("{ $and: [ { date: {$gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
