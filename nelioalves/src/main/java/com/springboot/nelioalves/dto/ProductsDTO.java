package com.springboot.nelioalves.dto;

import java.io.Serializable;

import com.springboot.nelioalves.entities.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private Double price;

  public ProductsDTO(ProductEntity object) {
    this.id = object.getId();
    this.name = object.getName();
    this.price = object.getPrice();
  }

}
