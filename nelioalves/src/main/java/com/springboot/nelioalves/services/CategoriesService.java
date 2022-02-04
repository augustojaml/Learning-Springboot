package com.springboot.nelioalves.services;

import com.springboot.nelioalves.entities.CategoryEntity;
import com.springboot.nelioalves.repositories.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

  @Autowired
  private CategoriesRepository repository;

  public CategoryEntity findById(Integer id) {
    CategoryEntity category = repository.findById(id).orElse(null);
    return category;
  }
}
