package com.springboot.nelioalves.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductEntity implements Serializable {

  private static final long serialVersionUID = 1L;

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

  @JsonIgnore
  @OneToMany(mappedBy = "id.product")
  private Set<ItemPurchaseEntity> items = new HashSet<>();

  public ProductEntity(Integer id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @JsonIgnore
  public List<PurchaseEntity> getPurchases() {
    List<PurchaseEntity> list = new ArrayList<PurchaseEntity>();
    for (ItemPurchaseEntity item : items) {
      list.add(item.getPurchase());
    }
    return list;
  }

}
