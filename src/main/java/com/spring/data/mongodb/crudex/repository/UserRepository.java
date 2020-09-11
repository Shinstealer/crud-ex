package com.spring.data.mongodb.crudex.repository;

import java.util.Optional;
import com.spring.data.mongodb.crudex.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User , String> {
  
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

}
