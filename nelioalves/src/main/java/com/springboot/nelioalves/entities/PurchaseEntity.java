package com.springboot.nelioalves.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "purchase")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PurchaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  @JsonFormat(pattern = "dd/MM/yy HH:mm")
  private Date instant;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchase")
  private PaymentEntity payment;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @ManyToOne
  @JoinColumn(name = "shipping_address_id")
  private AddressEntity shippingAddress;

  @OneToMany(mappedBy = "id.purchase")
  private Set<ItemPurchaseEntity> items = new HashSet<>();

  public PurchaseEntity(Integer id, Date instant, ClientEntity client, AddressEntity shippingAddress) {
    this.id = id;
    this.instant = instant;
    this.client = client;
    this.shippingAddress = shippingAddress;
  }

}
