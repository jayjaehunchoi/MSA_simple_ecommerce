package com.example.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDtos {
    private List<UserResponseDto> userResponseDtoList;

    public UserResponseDtos(List<UserResponseDto> userResponseDtoList) {
        this.userResponseDtoList = userResponseDtoList;
    }
}
