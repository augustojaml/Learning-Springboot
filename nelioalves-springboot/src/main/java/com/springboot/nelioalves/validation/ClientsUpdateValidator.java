package com.springboot.nelioalves.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.nelioalves.dto.ClientsDTO;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.exceptions.FieldMessage;
import com.springboot.nelioalves.repositories.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class ClientsUpdateValidator implements ConstraintValidator<ClientsUpdate, ClientsDTO> {

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private ClientsRepository repository;

  @Override
  public void initialize(ClientsUpdate ann) {
  }

  @Override
  public boolean isValid(ClientsDTO objDto, ConstraintValidatorContext context) {

    @SuppressWarnings("unchecked")
    Map<String, String> map = (Map<String, String>) request
        .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    Integer uriId = Integer.parseInt(map.get("id"));

    List<FieldMessage> list = new ArrayList<>();

    ClientEntity clientEntity = repository.findByEmail(objDto.getEmail());
    if (clientEntity != null && !clientEntity.getId().equals(uriId)) {
      list.add(new FieldMessage("email", "Email already exists"));
    }

    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
          .addConstraintViolation();
    }
    return list.isEmpty();
  }
}