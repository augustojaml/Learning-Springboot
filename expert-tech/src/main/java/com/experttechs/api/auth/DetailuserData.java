package com.experttechs.api.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.experttechs.api.models.UserModel;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetailuserData implements UserDetails {

  private final Optional<UserModel> user;

  public DetailuserData(Optional<UserModel> user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>();
  }

  @Override
  public String getPassword() {
    return this.user.orElse(new UserModel()).getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.orElse(new UserModel()).getLogin();
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

}
