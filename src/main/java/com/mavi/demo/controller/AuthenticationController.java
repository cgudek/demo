package com.mavi.demo.controller;

import static org.springframework.http.ResponseEntity.ok;


import com.mavi.demo.dto.AuthenticationRequestDTO;
import com.mavi.demo.dto.RefreshTokenRequestDTO;
import com.mavi.demo.repository.UserRepository;
import com.mavi.demo.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  UserRepository userRepository;

  @PostMapping("/signIn")
  public ResponseEntity signIn(@RequestBody AuthenticationRequestDTO data) {

    try {
      String username = data.getUsername();
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
      String token = jwtTokenProvider
          .createToken(username,
              userRepository.findByUsername(username)
                  .orElseThrow(() -> new UsernameNotFoundException(
                      "Username " + username + "not found"
                  )).getRoles());

      Map<Object, Object> model = new HashMap<>();
      model.put("username", username);
      model.put("token", token);
      return ResponseEntity.ok(model);
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied");
    }
  }

  @PostMapping("/refreshToken")
  public ResponseEntity refreshToken(@RequestBody RefreshTokenRequestDTO data) {

    try {
      String username = data.getUsername();

      if(jwtTokenProvider.validateToken(data.getToken()) ) {

        String token = jwtTokenProvider
            .createToken(username,
                userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException(
                        "Username " + username + "not found"
                    )).getRoles());

        Map<Object, Object> model = new HashMap<>();
        model.put("username", username);
        model.put("token", token);
        return ResponseEntity.ok(model);

      } else {
        throw new BadCredentialsException("Invalid token supplied");
      }
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid token supplied");
    }
  }
}
