package com.xapiens.assesment_xapiens.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xapiens.assesment_xapiens.Controller.UserController;
import com.xapiens.assesment_xapiens.Service.Impl.UserServiceImpl;
import com.xapiens.assesment_xapiens.dto.OneUserResponseDto;
import com.xapiens.assesment_xapiens.dto.UserResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("api/users")
@RestController
public class UserControllerImpl implements UserController {

  @Autowired
  UserServiceImpl userServiceImpl;

  @GetMapping
  @Override
  public ResponseEntity<?> allUser(@RequestParam(name = "page", required = true) String page, @RequestParam(name = "per_page", required = false) String perPage) {
    UserResponseDto data = userServiceImpl.getAllUser(page, perPage);
    return ResponseEntity.ok(data);
  }

  @GetMapping("/{id}")
  @Override
  public ResponseEntity<?> oneUser(@PathVariable Long id) {
    OneUserResponseDto data = userServiceImpl.oneUser(id);
    return ResponseEntity.ok(data);
  }
  
}
