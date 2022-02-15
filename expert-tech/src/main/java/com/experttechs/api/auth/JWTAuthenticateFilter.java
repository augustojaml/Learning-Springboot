package com.experttechs.api.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.experttechs.api.models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

  public static final int TOKEN_EXPIRATION = 60_000;
  public static final String TOKEN_SIGN = "e064fdb9-8e4d-478b-b6e8-4d0398f4e593";

  private final AuthenticationManager authenticationManager;

  public JWTAuthenticateFilter(AuthenticationManager authenticationManager) {
    setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      UserModel user = new ObjectMapper().readValue(request.getInputStream(), UserModel.class);
      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException("Authenticate failed");
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    DetailuserData detailuserData = (DetailuserData) authResult.getPrincipal();
    String token = JWT.create()
        .withSubject(detailuserData.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
        .sign(Algorithm.HMAC512(TOKEN_SIGN));

    response.getWriter().write(JWTValidateFilter.HEADER_PREFIX + token);
    response.getWriter().flush();
  }
}
