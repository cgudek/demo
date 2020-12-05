package com.mavi.demo.controller;

import com.mavi.demo.dto.UserDTO;
import com.mavi.demo.model.User;
import com.mavi.demo.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @GetMapping
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/listAllUsers")
  public ResponseEntity<List<String>> listAllUsers() {
    return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
  }

  @GetMapping("/getUser/{userName}")
  public ResponseEntity<UserDTO> getUser(@PathVariable("userName") String userName) {
    return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.OK);
  }

}
