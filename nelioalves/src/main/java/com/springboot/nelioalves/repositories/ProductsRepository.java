package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {

}
