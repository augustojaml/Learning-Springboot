package com.springboot.nelioalvesmongodb.dto;

import java.io.Serializable;

import com.springboot.nelioalvesmongodb.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String name;

  public AuthorDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
  }

}
