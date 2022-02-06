package com.springboot.nelioalves.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientsNewDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String CpfOrCnpj;

  private Integer type;

  private String neighborhood;

  private String number;

  private String complement;

  private String district;

  private String zipCode;

  private String phone1;

  private String phone2;

  private String phone3;

  private Integer cityId;
}
