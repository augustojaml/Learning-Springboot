package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.PurchaseEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PurchasesRepository extends JpaRepository<PurchaseEntity, Integer> {

  @Transactional(readOnly = true)
  Page<PurchaseEntity> findByClient(ClientEntity client, Pageable pageRequest);
}
