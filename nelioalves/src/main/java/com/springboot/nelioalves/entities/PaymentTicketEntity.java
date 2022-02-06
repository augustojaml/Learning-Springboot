package com.springboot.nelioalves.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.springboot.nelioalves.entities.enums.StatePaymentEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "payment_ticket")
@NoArgsConstructor
@JsonTypeName("payment_ticket")
public class PaymentTicketEntity extends PaymentEntity {

  @Getter
  @Setter
  @JsonFormat(pattern = "dd/MM/yy")
  private Date expireDate;

  @Getter
  @Setter
  @JsonFormat(pattern = "dd/MM/yy")
  private Date paymentDate;

  public PaymentTicketEntity(Integer id, StatePaymentEnum state, PurchaseEntity purchase, Date expireDate,
      Date paymentDate) {
    super(id, state, purchase);
    this.expireDate = expireDate;
    this.paymentDate = paymentDate;
  }
}
