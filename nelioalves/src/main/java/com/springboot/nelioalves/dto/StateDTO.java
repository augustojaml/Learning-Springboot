package com.springboot.nelioalves.dto;

import com.springboot.nelioalves.entities.StateEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO {

  private Integer id;
  private String name;

  public StateDTO(StateEntity state) {
    this.id = state.getId();
    this.name = state.getName();
  }
}
