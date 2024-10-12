package com.xapiens.assesment_xapiens.dto;

public class OneUserResponseDto {
  private UserDto data;

  public UserDto getData() {
    return data;
  }

  public OneUserResponseDto setData(UserDto data) {
    this.data = data;
    return this;
  }
}
