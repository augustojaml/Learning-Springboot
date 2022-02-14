package com.springboot.nelioalvesmongodb.repositories;

import com.springboot.nelioalvesmongodb.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

}
