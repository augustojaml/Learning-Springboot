package com.springboot.nelioalves.services;

import java.util.Optional;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.exceptions.ServiceDataIntegrityViolationException;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

  @Autowired
  private CategoriesRepository repository;

  public CategoryEntity findById(Integer id) {
    Optional<CategoryEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + CategoryEntity.class.getName()));
  }

  public CategoryEntity insert(CategoryEntity object) {
    object.setId(null);
    return repository.save(object);
  }

  public CategoryEntity update(CategoryEntity object) {
    this.findById(object.getId());
    return repository.save(object);
  }

  public void delete(Integer id) {
    this.findById(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException ex) {
      throw new ServiceDataIntegrityViolationException("Cannot delete category with products");
    }

  }
}
