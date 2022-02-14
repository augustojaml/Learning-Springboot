package com.springboot.nelioalvesmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @EqualsAndHashCode.Include
  private String id;

  private String name;

  private String email;

  @DBRef(lazy = true)
  private List<Post> posts = new ArrayList<>();

  public User(String id, String name, String email) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
  }
}
