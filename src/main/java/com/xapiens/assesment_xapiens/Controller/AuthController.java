package com.xapiens.assesment_xapiens.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import com.xapiens.assesment_xapiens.dto.LoginDto;

import jakarta.validation.Valid;

public interface AuthController {
  ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto, BindingResult result);
}
