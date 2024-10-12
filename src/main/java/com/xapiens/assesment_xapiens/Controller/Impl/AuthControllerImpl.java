package com.xapiens.assesment_xapiens.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xapiens.assesment_xapiens.Controller.AuthController;
import com.xapiens.assesment_xapiens.Service.Impl.AuthServiceImpl;
import com.xapiens.assesment_xapiens.dto.LoginDto;

import jakarta.validation.Valid;

import java.util.*;

@RequestMapping("/auth")
@RestController
public class AuthControllerImpl implements AuthController {

  @Autowired
  AuthServiceImpl authServiceImpl;

  @PostMapping("/login")
  @Override
  public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto, BindingResult result) {
    try {
      if (result.hasErrors()) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
      }

      String token = authServiceImpl.login(loginDto.getEmail(), loginDto.getPassword());
      return ResponseEntity.ok(token);
    } catch (Exception e) {
      System.err.println(e);
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
  }
  
}
