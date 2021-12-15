package com.example.userservice.dto;

import com.example.userservice.domain.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDate createDate;

    @Builder
    public UserResponseDto(Long id, String email, String password, String name, LocalDate createDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.createDate = createDate;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .createDate(user.getCreateDate())
                .build();
    }
}
