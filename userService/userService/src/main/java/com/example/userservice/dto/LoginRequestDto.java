package com.example.userservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDto {

    @NotBlank(message = "email cannot be blank")
    @Email
    private String email;

    @NotBlank(message = "password cannot be blank")
    private String password;

}
