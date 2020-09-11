package com.spring.data.mongodb.crudex.entity;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document("users")
@Getter
@Setter
public class User {
  @Id
  private String id;

  @NotNull
  @Size(max = 20)
  private String username;

  @NotNull
  @Size(max = 50)
  @Email
  private String email;

  @NotNull
  @Size(max = 120)
  private String password;

  @DBRef
  Set<Role> roles = new HashSet<>();
}
