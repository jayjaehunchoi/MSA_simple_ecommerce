package com.example.userservice.domain;

import com.example.userservice.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserRequestDto userRequestDto) {
        userRequestDto.encodePassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return userRepository.save(userRequestDto.toEntity());
    }
}
