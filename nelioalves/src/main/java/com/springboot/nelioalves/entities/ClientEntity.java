package com.springboot.nelioalves.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.nelioalves.entities.enums.TypeClient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "client")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  @EqualsAndHashCode.Include
  private Integer id;

  @Getter
  @Setter
  private String nome;

  @Getter
  @Setter
  private String email;

  @Getter
  @Setter
  private String CpfOrCnpj;

  private Integer type;

  @Getter
  @Setter
  @OneToMany(mappedBy = "client")
  @JsonManagedReference
  private List<AddressEntity> addresses = new ArrayList<>();

  @Getter
  @Setter
  @ElementCollection
  @CollectionTable(name = "phone")
  private Set<String> phones = new HashSet<>();

  public ClientEntity(Integer id, String nome, String email, String CpfOrCnpj, TypeClient type) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.CpfOrCnpj = CpfOrCnpj;
    this.type = type.getCode();
  }

  public TypeClient getType() {
    return TypeClient.toEnum(type);
  }

  public void setType(TypeClient type) {
    this.type = type.getCode();
  }

}
