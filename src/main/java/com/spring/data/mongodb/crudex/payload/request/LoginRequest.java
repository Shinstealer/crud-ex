package com.spring.data.mongodb.crudex.payload.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

}
