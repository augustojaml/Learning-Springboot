package com.springboot.nelioalves.services;

import java.util.Optional;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

  @Autowired
  private ClientsRepository repository;

  public ClientEntity findById(Integer id) {
    Optional<ClientEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + ClientEntity.class.getName()));
  }
}
