package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.AddressEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<AddressEntity, Integer> {

}
