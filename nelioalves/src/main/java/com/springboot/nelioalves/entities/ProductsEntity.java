package com.springboot.nelioalves.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@NoArgsConstructor
// @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  private String name;

  private Double price;

  @JsonBackReference
  @ManyToMany
  @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private List<CategoryEntity> categories = new ArrayList<>();

  public ProductsEntity(Integer id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

}
