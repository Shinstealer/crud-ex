package com.spring.data.mongodb.crudex.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.spring.data.mongodb.crudex.payload.request.LoginRequest;
import com.spring.data.mongodb.crudex.payload.response.JwtResponse;
import com.spring.data.mongodb.crudex.repository.RoleRepository;
import com.spring.data.mongodb.crudex.repository.UserRepository;
import com.spring.data.mongodb.crudex.security.jwt.JwtUtils;
import com.spring.data.mongodb.crudex.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthRestController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticatedUser(@Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream().map(role -> role.getAuthority())
        .collect(Collectors.toList());


    return ResponseEntity.ok(
      new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
        userDetails.getEmail(), roles)
    );
  }
}
