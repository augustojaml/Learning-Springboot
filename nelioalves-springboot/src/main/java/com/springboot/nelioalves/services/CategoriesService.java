package com.springboot.nelioalves.services;

import java.util.List;
import java.util.Optional;

import com.springboot.nelioalves.dto.CategoriesDTO;
import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.exceptions.ServiceDataIntegrityViolationException;
import com.springboot.nelioalves.exceptions.ServiceIllegalArgumentException;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
    CategoryEntity newObject = findById(object.getId());
    this.updateDate(newObject, object);
    return repository.save(newObject);
  }

  public void delete(Integer id) {
    this.findById(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException ex) {
      throw new ServiceDataIntegrityViolationException("Cannot delete category with products");
    }

  }

  public List<CategoryEntity> findAll() {
    return repository.findAll();
  }

  public Page<CategoryEntity> findPerPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    try {
      PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
      return repository.findAll(pageRequest);
    } catch (Exception ex) {
      throw new ServiceIllegalArgumentException("Invalid search parameters");
    }
  }

  public CategoryEntity fromDTO(CategoriesDTO object) {
    return new CategoryEntity(object.getId(), object.getName());
  }

  private void updateDate(CategoryEntity newObject, CategoryEntity object) {
    newObject.setName(object.getName());
  }

}
