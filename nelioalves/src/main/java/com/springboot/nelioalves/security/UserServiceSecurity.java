package com.springboot.nelioalves.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.springboot.nelioalves.entities.enums.ProfileEnum;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserServiceSecurity implements UserDetails {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public UserServiceSecurity(Integer id, String email, String password, Set<ProfileEnum> profiles) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.authorities = profiles.stream().map(profile -> new SimpleGrantedAuthority(profile.getDescription()))
        .collect(Collectors.toList());
    ;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public boolean hasHole(ProfileEnum profile) {
    return getAuthorities().contains(new SimpleGrantedAuthority(profile.getDescription()));
  }
}
