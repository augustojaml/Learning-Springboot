package com.springboot.nelioalves.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.springboot.nelioalves.dto.ClientsDTO;
import com.springboot.nelioalves.dto.ClientsNewDTO;
import com.springboot.nelioalves.entities.AddressEntity;
import com.springboot.nelioalves.entities.CityEntity;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.enums.ProfileEnum;
import com.springboot.nelioalves.entities.enums.TypeClientEnum;
import com.springboot.nelioalves.exceptions.ServiceAuthorizationException;
import com.springboot.nelioalves.exceptions.ServiceDataIntegrityViolationException;
import com.springboot.nelioalves.exceptions.ServiceIllegalArgumentException;
import com.springboot.nelioalves.exceptions.ServiceObjectNotFoundException;
import com.springboot.nelioalves.repositories.AddressesRepository;
import com.springboot.nelioalves.repositories.ClientsRepository;
import com.springboot.nelioalves.security.UserServiceSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClientsService {

  @Autowired
  private ClientsRepository repository;

  @Autowired
  private AddressesRepository addressesRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private S3Service s3Service;

  @Autowired
  private ImageService imageService;

  @Value("${img.prefix.client.profile}")
  private String clientPrefix;

  @Value("${img.profile.size}")
  private Integer imageSize;

  public ClientEntity findById(Integer id) {
    UserServiceSecurity userServiceSecurity = UserService.authenticated();
    if (userServiceSecurity == null
        || !userServiceSecurity.hasHole(ProfileEnum.ADMIN) && !id.equals(userServiceSecurity.getId())) {
      throw new ServiceAuthorizationException("Access denied");

    }
    Optional<ClientEntity> object = repository.findById(id);
    return object.orElseThrow(
        () -> new ServiceObjectNotFoundException(
            "Object with identifier " + id + " | Class: " + ClientEntity.class.getName()));
  }

  public ClientEntity findByEmail(String email) {
    UserServiceSecurity userServiceSecurity = UserService.authenticated();
    if (userServiceSecurity == null
        || !userServiceSecurity.hasHole(ProfileEnum.ADMIN) && !email.equals(userServiceSecurity.getUsername())) {
      throw new ServiceAuthorizationException("Access denied");
    }
    ClientEntity object = repository.findByEmail(email);
    if (object == null) {
      throw new ServiceObjectNotFoundException(
          "Object with identifier " + userServiceSecurity.getId() + " | Class: " + ClientEntity.class.getName());
    }
    return object;
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

  public ClientEntity fromDTO(ClientsDTO objectDTO) {
    return new ClientEntity(objectDTO.getId(), objectDTO.getName(), objectDTO.getEmail(), null, null, null);
  }

  private void updateDate(ClientEntity newObject, ClientEntity object) {
    newObject.setName(object.getName());
    newObject.setEmail(object.getEmail());
  }

  public ClientEntity fromDTO(@Valid ClientsNewDTO objectDTO) {
    ClientEntity clientEntity = new ClientEntity(null, objectDTO.getName(), objectDTO.getEmail(),
        objectDTO.getCpfOrCnpj(), TypeClientEnum.toEnum(objectDTO.getType()),
        bCryptPasswordEncoder.encode(objectDTO.getPassword()));

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

  public URI uploadProfilePicture(MultipartFile multipartFile) {

    UserServiceSecurity userServiceSecurity = UserService.authenticated();
    if (userServiceSecurity == null) {
      throw new ServiceAuthorizationException("Access Denied");
    }

    BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
    String fileName = clientPrefix + userServiceSecurity.getId() + ".jpg";
    jpgImage = imageService.cropSquare(jpgImage);
    jpgImage = imageService.resize(jpgImage, imageSize);

    return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");

  }
}
