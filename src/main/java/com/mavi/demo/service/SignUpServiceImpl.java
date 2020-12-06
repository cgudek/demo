package com.mavi.demo.service;

import com.mavi.demo.dto.SignUpDTO;
import com.mavi.demo.model.User;
import com.mavi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SignUpServiceImpl implements SignUpService {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  ObjectMappingService om;

  @Autowired
  UserRepository userRepository;

  @Override
  public void signUp(SignUpDTO signUpDTO) {
    try {
      if (signUpDTO.getPassword().equals(signUpDTO.getMatchingPassword())) {
        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getMatchingPassword()));
      }
      User newUser = (User) om.mapToObject(om.writeValueAsString(signUpDTO), User.class);
      if (userRepository.findByUsername(newUser.getUsername()).isEmpty()) {
        userRepository.save(newUser);
      } else {
        throw new ResponseStatusException(HttpStatus.CONFLICT, "This user already exist.");
      }
    } catch (Exception ex) {
      throw new RequestRejectedException("Unmatched type exception.");
    }
  }
}
