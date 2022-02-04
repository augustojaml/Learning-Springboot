package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoryEntity, Integer> {

}
