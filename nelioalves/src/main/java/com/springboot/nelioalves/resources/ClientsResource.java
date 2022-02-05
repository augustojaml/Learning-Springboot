package com.springboot.nelioalves.resources;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.services.ClientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {

  @Autowired
  private ClientsService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<ClientEntity> findById(@PathVariable Integer id) {
    ClientEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }

}
