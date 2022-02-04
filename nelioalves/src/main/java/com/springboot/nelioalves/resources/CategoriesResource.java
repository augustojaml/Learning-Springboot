package com.springboot.nelioalves.resources;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.services.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesResource {

  @Autowired
  private CategoriesService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> findById(@PathVariable Integer id) {
    CategoryEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }

}
