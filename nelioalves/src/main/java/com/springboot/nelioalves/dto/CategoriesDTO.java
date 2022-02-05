package com.springboot.nelioalves.dto;

import java.io.Serializable;

import com.springboot.nelioalves.entities.CategoryEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriesDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String name;

  public CategoriesDTO(CategoryEntity object) {
    this.id = object.getId();
    this.name = object.getName();
  }
}
