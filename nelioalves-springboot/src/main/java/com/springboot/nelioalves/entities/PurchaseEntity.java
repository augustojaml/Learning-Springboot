package com.springboot.nelioalves.entities;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
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

  public double getValueTotal() {
    double sum = 0;
    for (ItemPurchaseEntity item : items) {
      sum = sum + item.getSubTotal();
    }
    return sum;
  }

  @Override
  public String toString() {

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    StringBuilder builder = new StringBuilder();
    builder.append("\n================================================================================\n");
    builder.append("Purchase Number: ");
    builder.append(getId());
    builder.append(", Instant: ");
    builder.append(sdf.format(getInstant()));
    builder.append(", Client: ");
    builder.append(getClient().getName());
    builder.append(", State of payment: ");
    builder.append(getPayment().getState().getDescription());
    builder.append("\nDetails \n");

    for (ItemPurchaseEntity item : getItems()) {
      builder.append(item.toString());
    }

    builder.append("Value Total ");
    builder.append(nf.format(getValueTotal()));
    builder.append("\n================================================================================\n");

    return builder.toString();
  }
}