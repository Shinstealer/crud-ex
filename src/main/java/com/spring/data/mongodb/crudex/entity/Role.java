package com.spring.data.mongodb.crudex.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document("roles")
@Getter
@Setter
public class Role {
  @Id
  private String id;

  private ERole role_kind;
}
