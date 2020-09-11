package com.spring.data.mongodb.crudex.controller;

import com.spring.data.mongodb.crudex.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }


  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }

  @PostMapping("/logout")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<?> logoutUser() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    securityContext.setAuthentication(null);
    return ResponseEntity.ok(new MessageResponse("logout successful"));
  }
}
