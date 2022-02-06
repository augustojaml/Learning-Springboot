package com.springboot.nelioalves.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot.nelioalves.dto.ClientsNewDTO;
import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.entities.enums.TypeClientEnum;
import com.springboot.nelioalves.exceptions.FieldMessage;
import com.springboot.nelioalves.repositories.ClientsRepository;
import com.springboot.nelioalves.validation.utils.BR;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientsInsertValidator implements ConstraintValidator<ClientsInsert, ClientsNewDTO> {

  @Autowired
  private ClientsRepository repository;

  @Override
  public void initialize(ClientsInsert ann) {
  }

  @Override
  public boolean isValid(ClientsNewDTO objDto, ConstraintValidatorContext context) {
    List<FieldMessage> list = new ArrayList<>();

    if (objDto.getType().equals(TypeClientEnum.NATURALPERSON.getCode()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
      list.add(new FieldMessage("CpfOrCnpj", "CPF Invalid"));
    }

    if (objDto.getType().equals(TypeClientEnum.LEGALPERSON.getCode()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
      list.add(new FieldMessage("CpfOrCnpj", "CNPJ Invalid"));
    }

    ClientEntity clientEntity = repository.findByEmail(objDto.getEmail());
    if (clientEntity != null) {
      list.add(new FieldMessage("email", "Email already existis"));
    }

    for (FieldMessage e : list) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage())
          .addPropertyNode(e.getFieldName()).addConstraintViolation();
    }
    return list.isEmpty();
  }
}