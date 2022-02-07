package com.springboot.nelioalves.resources;

import java.util.List;

import com.springboot.nelioalves.dto.ProductsDTO;
import com.springboot.nelioalves.entities.ProductEntity;
import com.springboot.nelioalves.services.ProductsService;
import com.springboot.nelioalves.utils.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsResource {

  @Autowired
  private ProductsService service;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<ProductEntity> findById(@PathVariable Integer id) {
    ProductEntity object = service.findById(id);
    return ResponseEntity.ok().body(object);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Page<ProductsDTO>> findPage(
      @RequestParam(value = "name", defaultValue = "") String name,
      @RequestParam(value = "categories", defaultValue = "") String categories,
      @RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
    String nameDecoded = URL.decodeParam(name);
    List<Integer> ids = URL.decodeIntList(categories);
    Page<ProductEntity> list = service.search(nameDecoded, ids, page, linesPerPage, orderBy, direction);
    Page<ProductsDTO> listDto = list.map(object -> new ProductsDTO(object));
    return ResponseEntity.ok().body(listDto);
  }

}
