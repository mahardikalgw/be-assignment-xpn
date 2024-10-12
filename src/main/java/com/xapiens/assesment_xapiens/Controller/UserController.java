package com.xapiens.assesment_xapiens.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserController {
  ResponseEntity<?> allUser(@RequestParam(name = "page", required = true) String page, @RequestParam(name = "per_page") String perPage);
  ResponseEntity<?> oneUser(@PathVariable Long id);
}
