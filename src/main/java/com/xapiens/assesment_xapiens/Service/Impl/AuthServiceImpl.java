package com.xapiens.assesment_xapiens.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.xapiens.assesment_xapiens.Service.AuthService;
import com.xapiens.assesment_xapiens.dto.LoginDto;
import com.xapiens.assesment_xapiens.dto.ReqresLoginResponseDto;
import com.xapiens.assesment_xapiens.utils.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public String login(String email, String password) {
    try {
      String loginUrl = "https://reqres.in/api/login";
      LoginDto loginDto = new LoginDto().setEmail(email).setPassword(password);
      ReqresLoginResponseDto response = restTemplate.postForObject(loginUrl, loginDto, ReqresLoginResponseDto.class);
      System.out.println(response.getToken());
      return jwtUtil.generateToken(email);
    } catch (HttpClientErrorException e) {
      throw new RuntimeException("Login failed: invalid credentials");
    }
  }
  
}
