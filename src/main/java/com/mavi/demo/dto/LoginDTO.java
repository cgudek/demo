package com.mavi.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {

  @NotNull(message = "Username may not be null.")
  @NotEmpty(message = "Username may not be empty.")
  private String userName;

  @NotNull(message = "Password may not be null.")
  @NotEmpty(message = "Password may not be empty.")
  private String password;

}
