package com.springboot.nelioalves.entities.enums;

public enum StatePaymentEnum {
  PENDING(1, "Pending"),
  LIQUIDATED(2, "Liquidated"),
  CANCELED(3, "Canceled");

  private int code;
  private String description;

  private StatePaymentEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public static StatePaymentEnum toEnum(Integer code) {
    if (code == null) {
      return null;
    }

    for (StatePaymentEnum type : StatePaymentEnum.values()) {
      if (code.equals(type.getCode())) {
        return type;
      }
    }

    throw new IllegalArgumentException("Code Type Cliente invalid: " + code);
  }
}
