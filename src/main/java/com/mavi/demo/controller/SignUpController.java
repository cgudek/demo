package com.mavi.demo.controller;

import com.mavi.demo.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

  @PutMapping("/signUp")
  public ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
    return new ResponseEntity<String>("Success.", HttpStatus.OK);
  }
}
