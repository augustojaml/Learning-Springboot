package com.springboot.nelioalves.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.springboot.nelioalves.validation.ClientsInsert;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ClientsInsert
public class ClientsNewDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotEmpty(message = "Field required")
  @Length(min = 5, max = 120, message = "This field should must min 5 char and max 120")
  private String name;

  @NotEmpty(message = "Field required")
  @Email(message = "Invalid email")
  private String email;

  @NotEmpty(message = "Field required")
  private String CpfOrCnpj;

  private Integer type;

  @NotEmpty(message = "Field required")
  private String neighborhood;

  @NotEmpty(message = "Field required")
  private String number;

  private String complement;

  private String district;

  @NotEmpty(message = "Field required")
  private String zipCode;

  @NotEmpty(message = "Field required")
  private String phone1;

  private String phone2;

  private String phone3;

  private Integer cityId;
}
