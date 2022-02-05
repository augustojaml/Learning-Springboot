package com.springboot.nelioalves.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

  private List<FieldMessage> fields = new ArrayList<>();

  public ValidationError(Integer status, String message, Long timesStamp) {
    super(status, message, timesStamp);
  }

  public List<FieldMessage> getErrors() {
    return fields;
  }

  public void addError(String fieldName, String message) {
    fields.add(new FieldMessage(fieldName, message));
  }

}
