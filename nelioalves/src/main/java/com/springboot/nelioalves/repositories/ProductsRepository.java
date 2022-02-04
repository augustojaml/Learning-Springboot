package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ProductsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {

}
