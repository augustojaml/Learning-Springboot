package com.springboot.nelioalves.entities;

import javax.persistence.Entity;

import com.springboot.nelioalves.entities.enums.StatePaymentEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "payment_card")
@NoArgsConstructor
public class PaymentCardEntity extends PaymentEntity {

  @Getter
  @Setter
  private Integer numberOfInstallments;

  public PaymentCardEntity(Integer id, StatePaymentEnum state, PurchaseEntity purchase, Integer numberOfInstallments) {
    super(id, state, purchase);
    this.numberOfInstallments = numberOfInstallments;
  }

}
