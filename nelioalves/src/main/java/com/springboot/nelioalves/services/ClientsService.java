package com.springboot.nelioalves.services;

import java.util.List;
import java.util.Optional;

import com.springboot.nelioalves.dto.ClientsDTO;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.exceptions.ServiceDataIntegrityViolationException;
import com.springboot.nelioalves.exceptions.ServiceIllegalArgumentException;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

  public ClientEntity insert(ClientEntity object) {
    object.setId(null);
    return repository.save(object);
  }

  public ClientEntity update(ClientEntity object) {
    ClientEntity newObject = findById(object.getId());
    this.updateDate(newObject, object);
    return repository.save(newObject);
  }

  public void delete(Integer id) {
    this.findById(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException ex) {
      throw new ServiceDataIntegrityViolationException("Cannot delete related entities");
    }

  }

  public List<ClientEntity> findAll() {
    return repository.findAll();
  }

  public Page<ClientEntity> findPerPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    try {
      PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
      return repository.findAll(pageRequest);
    } catch (Exception ex) {
      throw new ServiceIllegalArgumentException("Invalid search parameters");
    }
  }

  public ClientEntity fromDTO(ClientsDTO objectDTO) {
    return new ClientEntity(objectDTO.getId(), objectDTO.getName(), objectDTO.getEmail(), null, null);
  }

  private void updateDate(ClientEntity newObject, ClientEntity object) {
    newObject.setName(object.getName());
    newObject.setEmail(object.getEmail());
  }
}
