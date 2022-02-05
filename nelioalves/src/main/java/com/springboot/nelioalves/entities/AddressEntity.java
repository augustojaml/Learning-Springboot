package com.springboot.nelioalves.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  private String neighborhood;

  private String number;

  private String complement;

  private String district;

  private String zipCode;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private CityEntity city;

}
