package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.ClientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<ClientEntity, Integer> {

}
