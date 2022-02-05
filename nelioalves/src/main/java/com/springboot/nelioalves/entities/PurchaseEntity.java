package com.springboot.nelioalves.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "purchase")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PurchaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  private Date instant;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchase")
  private PaymentEntity payment;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @ManyToOne
  @JoinColumn(name = "shipping_address_id")
  private AddressEntity shippingAddress;

  public PurchaseEntity(Integer id, Date instant, ClientEntity client, AddressEntity shippingAddress) {
    this.id = id;
    this.instant = instant;
    this.client = client;
    this.shippingAddress = shippingAddress;
  }

}
