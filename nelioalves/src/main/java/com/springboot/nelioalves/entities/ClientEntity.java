package com.springboot.nelioalves.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.nelioalves.entities.enums.ProfileEnum;
import com.springboot.nelioalves.entities.enums.TypeClientEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "client")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String email;

  @Getter
  @Setter
  private String CpfOrCnpj;

  private Integer type;

  @Getter
  @Setter
  @JsonIgnore
  private String password;

  @Getter
  @Setter
  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<AddressEntity> addresses = new ArrayList<>();

  @Getter
  @Setter
  @ElementCollection
  @CollectionTable(name = "phone")
  private Set<String> phones = new HashSet<>();

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "profile")
  private Set<Integer> profiles = new HashSet<>();

  @Getter
  @Setter
  @JsonIgnore
  @OneToMany(mappedBy = "client")
  private List<PurchaseEntity> purchases = new ArrayList<>();

  @Getter
  @Setter
  private String imageUrl;

  public ClientEntity() {
    this.addProfile(ProfileEnum.CLIENT);
  }

  public ClientEntity(Integer id, String name, String email, String CpfOrCnpj, TypeClientEnum type, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.CpfOrCnpj = CpfOrCnpj;
    this.type = (type == null) ? null : type.getCode();
    this.password = password;
    this.addProfile(ProfileEnum.CLIENT);
  }

  public TypeClientEnum getType() {
    return TypeClientEnum.toEnum(type);
  }

  public void setType(TypeClientEnum type) {
    this.type = type.getCode();
  }

  public Set<ProfileEnum> getProfiles() {
    return profiles.stream().map(x -> ProfileEnum.toEnum(x)).collect(Collectors.toSet());
  }

  public void addProfile(ProfileEnum profile) {
    profiles.add(profile.getCode());
  }

}
