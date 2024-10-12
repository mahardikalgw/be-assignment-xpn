package com.xapiens.assesment_xapiens.Service;


import com.xapiens.assesment_xapiens.dto.OneUserResponseDto;
import com.xapiens.assesment_xapiens.dto.UserResponseDto;

public interface UserService {
  UserResponseDto getAllUser(String page, String perPage);
  OneUserResponseDto oneUser(Long id);
}
