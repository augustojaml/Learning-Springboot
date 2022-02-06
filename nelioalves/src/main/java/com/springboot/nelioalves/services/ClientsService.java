package com.springboot.nelioalves.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springboot.nelioalves.dto.ClientsDTO;
import com.springboot.nelioalves.dto.ClientsNewDTO;
import com.springboot.nelioalves.entities.AddressEntity;
import com.springboot.nelioalves.entities.CityEntity;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.enums.TypeClientEnum;
import com.springboot.nelioalves.exceptions.ServiceDataIntegrityViolationException;
import com.springboot.nelioalves.exceptions.ServiceIllegalArgumentException;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.AddressesRepository;
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

  @Autowired
  private AddressesRepository addressesRepository;

  public ClientEntity findById(Integer id) {
    Optional<ClientEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + ClientEntity.class.getName()));
  }

  public ClientEntity insert(ClientEntity object) {
    object.setId(null);
    object = repository.save(object);
    addressesRepository.saveAll(object.getAddresses());
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

  public ClientEntity fromDTO(@Valid ClientsNewDTO objectDTO) {
    ClientEntity clientEntity = new ClientEntity(null, objectDTO.getName(), objectDTO.getEmail(),
        objectDTO.getCpfOrCnpj(), TypeClientEnum.toEnum(objectDTO.getType()));

    CityEntity cityEntity = new CityEntity(objectDTO.getType(), null, null);

    AddressEntity addressEntity = new AddressEntity(null, objectDTO.getNeighborhood(), objectDTO.getNumber(),
        objectDTO.getComplement(), objectDTO.getDistrict(), objectDTO.getZipCode(), clientEntity, cityEntity);

    clientEntity.getAddresses().add(addressEntity);
    clientEntity.getPhones().add(objectDTO.getPhone1());

    if (objectDTO.getPhone2() != null) {
      clientEntity.getPhones().add(objectDTO.getPhone2());
    }
    if (objectDTO.getPhone3() != null) {
      clientEntity.getPhones().add(objectDTO.getPhone3());
    }
    return clientEntity;
  }
}
