package com.springboot.nelioalves.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.springboot.nelioalves.entities.ClientEntity;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientsDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  @NotEmpty(message = "Field required")
  @Length(min = 5, max = 120, message = "This field should must min 5 char and max 120")
  private String name;

  @NotEmpty(message = "Field required")
  @Email(message = "Invalid email")
  private String email;

  public ClientsDTO(ClientEntity object) {
    id = object.getId();
    name = object.getName();
    email = object.getEmail();
  }

}
