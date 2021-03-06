package com.mavi.demo.dto;

import lombok.Data;

@Data
public class SignUpDTO {
  private String username;
  private String password;
  private String matchingPassword;
  private String name;
  private String surname;
  private String addressDetail;
  private String city;
  private String phone;
}
