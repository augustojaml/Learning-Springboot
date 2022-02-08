package com.springboot.nelioalves.repositories;

import java.util.List;

import com.springboot.nelioalves.entities.StateEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StatesRepository extends JpaRepository<StateEntity, Integer> {

  @Transactional(readOnly = true)
  public List<StateEntity> findAllByOrderByName();
}
