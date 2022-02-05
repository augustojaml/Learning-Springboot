package com.springboot.nelioalves.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class ItemPurchasePKEmbeddable implements Serializable {

  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn(name = "purchase_id")
  private PurchaseEntity purchase;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;
}
