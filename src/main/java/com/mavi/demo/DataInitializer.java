package com.mavi.demo;

import com.mavi.demo.model.User;
import com.mavi.demo.repository.UserRepository;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {

    userRepository.save(User.builder()
        .username("user")
        .password(this.passwordEncoder.encode("password"))
        .name("user_mavi")
        .surname("user_dev")
        .addressDetail("atasehir")
        .city("istanbul")
        .phone("555-555-55-55")
        .roles(Arrays.asList("ROLE_USER"))
        .build()
    );

    userRepository.save(User.builder()
        .username("admin")
        .password(this.passwordEncoder.encode("admin"))
        .name("admin_mavi")
        .surname("admin_dev")
        .addressDetail("atasehir")
        .city("istanbul")
        .phone("555-555-55-55")
        .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
        .build()
    );

    log.debug("printing all users...");
    userRepository.findAll().forEach(v -> log.debug(" User :" + v.toString()));
  }
}

