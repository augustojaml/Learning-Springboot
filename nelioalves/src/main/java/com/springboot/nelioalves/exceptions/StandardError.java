package com.springboot.nelioalves.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError {

  private Integer status;

  private String message;

  private Long timesStamp;
}
