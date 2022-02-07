package com.springboot.nelioalves.resources;

import javax.servlet.http.HttpServletResponse;

import com.springboot.nelioalves.security.JWTUtil;
import com.springboot.nelioalves.security.UserServiceSecurity;
import com.springboot.nelioalves.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

  @Autowired
  private JWTUtil jwtUtil;

  @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
  public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
    UserServiceSecurity userServiceSecurity = UserService.authenticated();
    String token = jwtUtil.generateToken(userServiceSecurity.getUsername());
    response.addHeader("Authorization", "Bearer " + token);
    return ResponseEntity.noContent().build();
  }

}
