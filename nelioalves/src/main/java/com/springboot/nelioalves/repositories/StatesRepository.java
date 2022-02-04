package com.springboot.nelioalves.repositories;

import com.springboot.nelioalves.entities.StateEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<StateEntity, Integer> {

}
