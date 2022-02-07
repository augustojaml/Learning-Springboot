package com.springboot.nelioalves.services;

import com.springboot.nelioalves.entities.ClientEntity;
import com.springboot.nelioalves.repositories.ClientsRepository;
import com.springboot.nelioalves.security.UserServiceSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private ClientsRepository clientsRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    ClientEntity client = clientsRepository.findByEmail(email);
    if (client == null) {
      throw new UsernameNotFoundException(email);
    }
    return new UserServiceSecurity(client.getId(), client.getName(), client.getPassword(), client.getProfiles());
  }

}
