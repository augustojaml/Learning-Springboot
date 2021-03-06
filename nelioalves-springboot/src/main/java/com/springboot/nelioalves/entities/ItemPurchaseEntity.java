package com.springboot.nelioalves.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  @JsonIgnore
  @EmbeddedId
  private ItemPurchasePKEmbeddable id = new ItemPurchasePKEmbeddable();

  private Double discount;

  private Integer quantity;

  private Double price;

  public ItemPurchaseEntity(PurchaseEntity purchase, ProductEntity product, Double discount, Integer quantity,
      Double price) {
    super();
    id.setPurchase(purchase);
    id.setProduct(product);
    this.discount = discount;
    this.quantity = quantity;
    this.price = price;
  }

  public double getSubTotal() {
    return (this.price - this.discount) * quantity;
  }

  @JsonIgnore
  public PurchaseEntity getPurchase() {
    return id.getPurchase();
  }

  public void setPurchase(PurchaseEntity purchase) {
    this.id.setPurchase(purchase);
  }

  public ProductEntity getProduct() {
    return id.getProduct();
  }

  public void setProduct(ProductEntity product) {
    this.id.setProduct(product);
  }

  @Override
  public String toString() {

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    StringBuilder builder = new StringBuilder();
    builder.append("Name: ");
    builder.append(getProduct().getName());
    builder.append(", Quantity: ");
    builder.append(getQuantity());
    builder.append(", Price: ");
    builder.append(nf.format(getPrice()));
    builder.append(", SubTotal: ");
    builder.append(nf.format(getSubTotal()));
    builder.append("\n");
    return builder.toString();
  }

}
