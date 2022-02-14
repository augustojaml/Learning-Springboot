package com.springboot.nelioalvesmongodb.resources;

import java.util.Date;
import java.util.List;

import com.springboot.nelioalvesmongodb.domain.Post;
import com.springboot.nelioalvesmongodb.resources.utils.URL;
import com.springboot.nelioalvesmongodb.services.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

  @RequestMapping(value = "/title-search", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> findByTitleContaining(
      @RequestParam(value = "text", defaultValue = "") String text) {
    text = URL.decodeParam(text);

    List<Post> posts = this.postsService.findByTitleContaining(text);
    return ResponseEntity.ok().body(posts);
  }

  @RequestMapping(value = "/full-search", method = RequestMethod.GET)
  public ResponseEntity<List<Post>> fullSearch(
      @RequestParam(value = "text", defaultValue = "") String text,
      @RequestParam(value = "minDate", defaultValue = "") String minDate,
      @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
    text = URL.decodeParam(text);
    Date min = URL.convertDate(minDate, new Date(0L));
    Date max = URL.convertDate(maxDate, new Date());

    List<Post> posts = this.postsService.fullSearch(text, min, max);
    return ResponseEntity.ok().body(posts);
  }

}
