package com.xapiens.assesment_xapiens.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDto {
  
  @Email(message = "Email should be valid")
  @NotBlank(message = "Email is required")
  private String email;

  @NotBlank(message = "Password is required")
  private String password;

  public String getEmail() {
    return email;
  }
  public LoginDto setEmail(String email) {
    this.email = email;
    return this;
  }
  public String getPassword() {
    return password;
  }
  public LoginDto setPassword(String password) {
    this.password = password;
    return this;
  }

}
