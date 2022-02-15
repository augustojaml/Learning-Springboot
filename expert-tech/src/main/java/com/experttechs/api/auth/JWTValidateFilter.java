package com.experttechs.api.auth;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTValidateFilter extends BasicAuthenticationFilter {

  public JWTValidateFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager);
  }

  public static final String HEADER_ATTRIBUTE = "Authorization";
  public static final String HEADER_PREFIX = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    String attribute = request.getHeader(HEADER_ATTRIBUTE);
    if (attribute == null) {
      chain.doFilter(request, response);
      return;
    }

    if (!attribute.startsWith(HEADER_PREFIX)) {
      chain.doFilter(request, response);
      return;
    }

    String token = attribute.replace(HEADER_PREFIX, "");
    UsernamePasswordAuthenticationToken autheticationToken = this.getAuthenticateToken(token);
    SecurityContextHolder.getContext().setAuthentication(autheticationToken);
    chain.doFilter(request, response);
  }

  private UsernamePasswordAuthenticationToken getAuthenticateToken(String token) {
    String user = JWT.require(Algorithm.HMAC512(JWTAuthenticateFilter.TOKEN_SIGN))
        .build()
        .verify(token)
        .getSubject();

    if (user == null) {
      return null;
    }

    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

  }

}
