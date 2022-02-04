package com.springboot.nelioalves.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "category")
@Data
@NoArgsConstructor
// @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  private String name;

  @ManyToMany(mappedBy = "categories")
  private List<ProductsEntity> products = new ArrayList<>();

  public CategoryEntity(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

}
