package com.springboot.nelioalves.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import com.springboot.nelioalves.entities.CategoryEntity;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriesDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  @NotEmpty(message = "This field not should must able null")
  @Length(min = 5, max = 80, message = "This field should must min 5 char and max 80")
  private String name;

  public CategoriesDTO(CategoryEntity object) {
    this.id = object.getId();
    this.name = object.getName();
  }
}
