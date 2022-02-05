package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends JpaRepository<PurchaseEntity, Integer> {

}
