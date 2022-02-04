package com.springboot.nelioalves.entities.enums;

public enum TypeClient {
  NATURALPERSON(1, "NATURAL PERSON"),
  LEGALPERSON(2, "LEGAL PERSON");

  private int code;
  private String description;

  private TypeClient(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public static TypeClient toEnum(Integer code) {
    if (code == null) {
      return null;
    }

    for (TypeClient type : TypeClient.values()) {
      if (code.equals(type.getCode())) {
        return type;
      }
    }

    throw new IllegalArgumentException("Code Type Cliente invalid: " + code);
  }
}
