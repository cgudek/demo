package com.mavi.demo.service;

import com.mavi.demo.dto.SignUpDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {
  void signUp(SignUpDTO signUpDTO);
}
