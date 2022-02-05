package com.springboot.nelioalves.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.springboot.nelioalves.entities.enums.StatePaymentEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "payment_ticket")
@NoArgsConstructor
public class PaymentTicketEntity extends PaymentEntity {

  @Getter
  @Setter
  private Date expireDate;

  @Getter
  @Setter
  private Date paymentDate;

  public PaymentTicketEntity(Integer id, StatePaymentEnum state, PurchaseEntity purchase, Date expireDate,
      Date paymentDate) {
    super(id, state, purchase);
    this.expireDate = expireDate;
    this.paymentDate = paymentDate;
  }
}
