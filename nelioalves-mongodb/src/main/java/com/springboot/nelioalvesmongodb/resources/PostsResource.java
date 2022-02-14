package com.springboot.nelioalvesmongodb.resources;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.services.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostsResource {

  @Autowired
  PostsService postsService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = this.postsService.findById(id);
    return ResponseEntity.ok().body(post);
  }

}
