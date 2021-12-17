package com.example.userservice.dto;

import com.example.userservice.domain.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRequestDto {

    @NotBlank(message = "email을 입력하세요")
    @Size(min = 2, message = "최소 2자 이상 입력해주세요")
    @Email
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Size(min = 8, message = "최소 8자 이상 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력하세요")
    @Size(min = 2, message = "최소 2자 이상 입력해주세요")
    private String name;

    public void encodePassword(String encodePassword) {
        password = encodePassword;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .email(email)
                .build();
    }
}
