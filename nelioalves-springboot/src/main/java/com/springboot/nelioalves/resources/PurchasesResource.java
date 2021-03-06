package com.springboot.nelioalves.resources;

import java.net.URI;

import javax.validation.Valid;

import com.springboot.nelioalves.entities.PurchaseEntity;
import com.springboot.nelioalves.services.PurchasesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Page<PurchaseEntity>> findPage(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "instant") String orderBy,
      @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
    Page<PurchaseEntity> objectsPage = service.findPage(page, linesPerPage, orderBy, direction);
    return ResponseEntity.ok().body(objectsPage);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@Valid @RequestBody PurchaseEntity object) {
    object = service.insert(object);
    URI uri = this.toURI(object);
    return ResponseEntity.created(uri).build();
  }

  private URI toURI(PurchaseEntity object) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(object.getId()).toUri();
    return uri;
  }
}
