package com.mavi.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mavi.demo.dto.UserDTO;
import com.mavi.demo.repository.UserRepository;
import com.mavi.demo.service.ObjectMappingService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log4j2
@RequestMapping("/v1/user")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  ObjectMappingService om;

  @GetMapping("/findAll")
  public List<Object> findAll() {

    return userRepository.findAll().stream().map(x -> {
      try {
        return om.mapToObject(om.writeValueAsString(x), UserDTO.class);
      } catch (JsonProcessingException e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
            "Return objects can not mapped.");
      }
    }).collect(Collectors.toList());
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
