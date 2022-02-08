package com.springboot.nelioalves.dto;

import com.springboot.nelioalves.entities.CityEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

  private Integer id;
  private String name;

  public CityDTO(CityEntity state) {
    this.id = state.getId();
    this.name = state.getName();
  }
}
