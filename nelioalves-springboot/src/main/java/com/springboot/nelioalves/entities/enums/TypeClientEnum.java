package com.springboot.nelioalves.entities.enums;

public enum TypeClientEnum {
  NATURALPERSON(1, "NATURAL PERSON"),
  LEGALPERSON(2, "LEGAL PERSON");

  private int code;
  private String description;

  private TypeClientEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public static TypeClientEnum toEnum(Integer code) {
    if (code == null) {
      return null;
    }

    for (TypeClientEnum type : TypeClientEnum.values()) {
      if (code.equals(type.getCode())) {
        return type;
      }
    }

    throw new IllegalArgumentException("Code Type Cliente invalid: " + code);
  }
}
