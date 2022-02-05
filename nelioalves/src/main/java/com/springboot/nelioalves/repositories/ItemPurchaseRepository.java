package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ItemPurchaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPurchaseRepository extends JpaRepository<ItemPurchaseEntity, Integer> {

}
