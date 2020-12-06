package com.mavi.demo.controller;

import com.mavi.demo.dto.SignUpDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class SignUpController {

  @PutMapping("/signUp")
  public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpDTO) {
    return new ResponseEntity<String>("Success.", HttpStatus.OK);
  }
}
