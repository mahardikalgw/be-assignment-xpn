package com.xapiens.assesment_xapiens.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.xapiens.assesment_xapiens.Service.UserService;
import com.xapiens.assesment_xapiens.dto.OneUserResponseDto;
import com.xapiens.assesment_xapiens.dto.UserResponseDto;

@Service
public class UserServiceImpl implements UserService {

  private final String BASE_URL = "https://reqres.in/api/users";

  @Autowired
  RestTemplate restTemplate;

  @Override
  public UserResponseDto getAllUser(String page, String perPage) {
    try {
      String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("page", page)
        .queryParam("per_page", perPage)
        .toUriString();

      UserResponseDto responseDto = restTemplate.getForObject(url, UserResponseDto.class);
      return responseDto;
    } catch (HttpClientErrorException e) {
      throw new RuntimeException("Internal Server Error");
    }
  }

  @Override
  public OneUserResponseDto oneUser(Long id) {
    try {
      OneUserResponseDto responseDto = restTemplate.getForObject(BASE_URL + "/" + id, OneUserResponseDto.class);
      return responseDto;
    } catch (HttpClientErrorException e) {
      throw new RuntimeException("Internal Server Error");
    }
  }
  
}
