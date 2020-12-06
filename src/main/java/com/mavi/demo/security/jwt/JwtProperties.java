package com.mavi.demo.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

  private String secretKey = "mavidevsecret";
  private long validityInMs = 3600000;

}
