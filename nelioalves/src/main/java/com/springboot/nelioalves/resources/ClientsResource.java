package com.springboot.nelioalves.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.nelioalves.dto.ClientsDTO;
import com.springboot.nelioalves.dto.ClientsNewDTO;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.services.ClientsService;

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
@RequestMapping(value = "/clients")
public class ClientsResource {

  @Autowired
  private ClientsService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<ClientEntity> findById(@PathVariable Integer id) {
    ClientEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<ClientsDTO>> findAll() {
    List<ClientEntity> objects = service.findAll();
    List<ClientsDTO> objectsDTO = objects.stream().map(object -> new ClientsDTO(object))
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(objectsDTO);
  }

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ResponseEntity<Page<ClientsDTO>> findPage(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
    Page<ClientEntity> objects = service.findPerPage(page, linesPerPage, orderBy, direction);
    Page<ClientsDTO> objectsDTO = objects.map(obj -> new ClientsDTO(obj));
    return ResponseEntity.ok().body(objectsDTO);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@Valid @RequestBody ClientsNewDTO objectDTO) {
    System.out.println(objectDTO);
    ClientEntity object = service.fromDTO(objectDTO);
    object = service.insert(object);
    URI uri = this.toURI(object);
    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@Valid @RequestBody ClientsDTO objectDTO, @PathVariable Integer id) {
    ClientEntity object = service.fromDTO(objectDTO);
    object.setId(id);
    object = service.update(object);
    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  private URI toURI(ClientEntity object) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(object.getId()).toUri();
    return uri;
  }

}
