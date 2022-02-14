package com.springboot.nelioalves.services;

import java.util.List;

import com.springboot.nelioalves.entities.StateEntity;
import com.springboot.nelioalves.repositories.StatesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatesService {

  @Autowired
  StatesRepository statesRepository;

  public List<StateEntity> findAll() {
    return statesRepository.findAllByOrderByName();
  }

}
