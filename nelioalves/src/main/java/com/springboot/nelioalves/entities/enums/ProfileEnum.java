package com.springboot.nelioalves.entities.enums;

public enum ProfileEnum {

  ADMIN(1, "ROLE_ADMIN"),
  CLIENT(2, "ROLE_CLIENT");

  private int code;
  private String description;

  private ProfileEnum(int code, String description) {
    this.code = code;
    this.description = description;
  }

  public int getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public static ProfileEnum toEnum(Integer code) {
    if (code == null) {
      return null;
    }

    for (ProfileEnum type : ProfileEnum.values()) {
      if (code.equals(type.getCode())) {
        return type;
      }
    }

    throw new IllegalArgumentException("Code Type Cliente invalid: " + code);
  }
}
