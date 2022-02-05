package com.springboot.nelioalves.resources;

import java.net.URI;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.services.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

  @Autowired
  private CategoriesService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<CategoryEntity> findById(@PathVariable Integer id) {
    CategoryEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@RequestBody CategoryEntity object) {
    object = service.insert(object);
    URI uri = this.toURI(object);
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody CategoryEntity object, @PathVariable Integer id) {
    object.setId(id);
    object = service.update(object);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  private URI toURI(CategoryEntity object) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(object.getId()).toUri();
    return uri;
  }

}
