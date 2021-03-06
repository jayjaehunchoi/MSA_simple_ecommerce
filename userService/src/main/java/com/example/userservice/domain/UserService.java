package com.example.userservice.domain;

import com.example.userservice.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserRequestDto userRequestDto) {
        userRequestDto.encodePassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return userRepository.save(userRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("User Not Found");
        });
    }

    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>());
    }
}
