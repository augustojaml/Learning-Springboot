package com.springboot.nelioalves.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddressEntity {

  @EqualsAndHashCode.Include
  private Integer id;

  private String neighborhood;

  private String number;

  private String complement;

  private String district;

  private String zipCode;

  private ClientEntity client;

  private CityEntity city;

}
