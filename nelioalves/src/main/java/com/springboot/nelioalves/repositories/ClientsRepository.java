package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ClientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientsRepository extends JpaRepository<ClientEntity, Integer> {

  @Transactional(readOnly = true)
  ClientEntity findByEmail(String email);
}
