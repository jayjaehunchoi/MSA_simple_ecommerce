package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.domain.UserService;
import com.example.userservice.dto.UserRequestDto;
import com.example.userservice.dto.UserResponseDto;
import com.example.userservice.dto.UserResponseDtos;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user-service")
public class UsersController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("create user email = {}", userRequestDto.getEmail());
        User saveUser = userService.createUser(userRequestDto);
        return ResponseEntity.created(URI.create("/users-sevice/users" + saveUser.getId())).body(UserResponseDto.from(saveUser));
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponseDtos> getAllUsers() {
        List<UserResponseDto> userResponseDtos = userService.findAll().stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new UserResponseDtos(userResponseDtos));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(UserResponseDto.from(userService.findUserById(id)));
    }

    @GetMapping("/health-check")
    public String status(HttpServletRequest request) {
        return String.format("It's Working in User Service on Port %s", request.getServerPort());
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Simple E-Commerce";
    }
}
