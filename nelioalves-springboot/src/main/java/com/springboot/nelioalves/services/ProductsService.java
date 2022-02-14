package com.springboot.nelioalves.services;

import java.util.List;
import java.util.Optional;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.entities.ProductEntity;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.CategoriesRepository;
import com.springboot.nelioalves.repositories.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

  @Autowired
  private ProductsRepository repository;

  @Autowired
  private CategoriesRepository categoriesRepository;

  public ProductEntity findById(Integer id) {
    Optional<ProductEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + ProductEntity.class.getName()));
  }

  public Page<ProductEntity> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
      String direction) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
    List<CategoryEntity> categories = categoriesRepository.findAllById(ids);
    return repository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
  }
}
