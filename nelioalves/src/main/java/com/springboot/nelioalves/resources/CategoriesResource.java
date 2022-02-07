package com.springboot.nelioalves.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springboot.nelioalves.dto.CategoriesDTO;
import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.services.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<CategoriesDTO>> findAll() {
    List<CategoryEntity> objects = service.findAll();
    List<CategoriesDTO> objectsDTO = objects.stream().map(object -> new CategoriesDTO(object))
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(objectsDTO);
  }

  @RequestMapping(value = "/page", method = RequestMethod.GET)
  public ResponseEntity<Page<CategoriesDTO>> findPage(
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
    Page<CategoryEntity> objects = service.findPerPage(page, linesPerPage, orderBy, direction);
    Page<CategoriesDTO> objectsDTO = objects.map(obj -> new CategoriesDTO(obj));
    return ResponseEntity.ok().body(objectsDTO);
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> insert(@Valid @RequestBody CategoriesDTO objectDTO) {
    CategoryEntity object = service.fromDTO(objectDTO);
    object = service.insert(object);
    URI uri = this.toURI(object);
    return ResponseEntity.created(uri).build();
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@Valid @RequestBody CategoriesDTO objectDTO, @PathVariable Integer id) {
    CategoryEntity object = service.fromDTO(objectDTO);
    object.setId(id);
    object = service.update(object);
    return ResponseEntity.noContent().build();
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
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
