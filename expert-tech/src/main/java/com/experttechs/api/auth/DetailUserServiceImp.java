package com.experttechs.api.auth;

import java.util.Optional;

import com.experttechs.api.models.UserModel;
import com.experttechs.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailUserServiceImp implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserModel> user = this.userRepository.findByLogin(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User [" + username + "] not found");
    }
    return new DetailuserData(user);
  }

}
