package com.springboot.nelioalves.resources;

import com.springboot.nelioalves.entities.PurchaseEntity;
import com.springboot.nelioalves.services.PurchasesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchases")
public class PurchasesResource {

  @Autowired
  private PurchasesService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<PurchaseEntity> findById(@PathVariable Integer id) {
    PurchaseEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }
}
