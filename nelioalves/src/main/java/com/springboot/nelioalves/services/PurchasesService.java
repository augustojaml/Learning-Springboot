package com.springboot.nelioalves.services;

import java.util.Optional;

import com.springboot.nelioalves.entities.PurchaseEntity;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.PurchasesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasesService {

  @Autowired
  private PurchasesRepository repository;

  public PurchaseEntity findById(Integer id) {
    Optional<PurchaseEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + PurchaseEntity.class.getName()));
  }
}
