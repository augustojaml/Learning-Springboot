package com.springboot.nelioalves.services;

import com.springboot.nelioalves.security.UserServiceSecurity;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

  public static UserServiceSecurity authenticated() {
    try {
      return (UserServiceSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    } catch (Exception e) {
      return null;
    }
  }
}
