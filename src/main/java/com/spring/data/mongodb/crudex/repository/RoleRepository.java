package com.spring.data.mongodb.crudex.repository;

import java.util.Optional;
import com.spring.data.mongodb.crudex.entity.ERole;
import com.spring.data.mongodb.crudex.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

  Optional<Role> findByName(ERole roleKind);

}
