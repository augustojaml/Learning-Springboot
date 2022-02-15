package com.experttechs.api.repositories;

import java.util.Optional;

import com.experttechs.api.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
  public Optional<UserModel> findByLogin(String login);
}
