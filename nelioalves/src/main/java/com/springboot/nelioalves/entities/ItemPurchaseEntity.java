package com.springboot.nelioalves.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "item_purchase")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPurchaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include
  @EmbeddedId
  private ItemPurchasePKEmbeddable id = new ItemPurchasePKEmbeddable();

  private Double discount;

  private Integer quantity;

  private Double Price;

  public ItemPurchaseEntity(PurchaseEntity purchase, ProductEntity product, Double discount, Integer quantity,
      Double price) {
    super();
    id.setPurchase(purchase);
    id.setProduct(product);
    this.discount = discount;
    this.quantity = quantity;
    Price = price;
  }

  public PurchaseEntity getPurchase() {
    return id.getPurchase();
  }

  public ProductEntity getProduct() {
    return id.getProduct();
  }

}
