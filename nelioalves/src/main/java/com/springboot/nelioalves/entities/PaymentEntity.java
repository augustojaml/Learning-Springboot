package com.springboot.nelioalves.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.nelioalves.entities.enums.StatePaymentEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "payment")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class PaymentEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  @EqualsAndHashCode.Include
  @Id
  private Integer id;

  private Integer state;

  @Getter
  @Setter
  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "purchase_id")
  @MapsId
  private PurchaseEntity purchase;

  public PaymentEntity(Integer id, StatePaymentEnum state, PurchaseEntity purchase) {
    this.id = id;
    this.state = (state == null) ? null : state.getCode();
    this.purchase = purchase;
  }

  public StatePaymentEnum getState() {
    return StatePaymentEnum.toEnum(state);
  }

  public void setState(StatePaymentEnum state) {
    this.state = state.getCode();
  }
}
