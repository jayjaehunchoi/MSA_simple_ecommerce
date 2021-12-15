package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.domain.UserService;
import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users-service")
public class UsersController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("create user email = {}", userRequestDto.getEmail());
        User saveUser = userService.createUser(userRequestDto);
        return ResponseEntity.created(URI.create("/users-sevice/users" + saveUser.getId())).body(UserResponseDto.from(saveUser));
    }

    @GetMapping("/health-check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Simple E-Commerce";
    }
}
