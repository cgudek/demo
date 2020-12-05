package com.mavi.demo.controller;

import com.mavi.demo.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/listAllUsers")
  public ResponseEntity<List<String>> listAllUsers() {
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
  }

  @GetMapping("/getUser/{userName}")
  public ResponseEntity<UserDTO> getUser(@PathVariable("userName") String userName) {
    return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
  }
}
