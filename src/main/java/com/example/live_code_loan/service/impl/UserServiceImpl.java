package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.dto.user.request.UserRequest;
import com.example.live_code_loan.dto.user.response.UserResponse;
import com.example.live_code_loan.entity.AppUser;
import com.example.live_code_loan.entity.User;
import com.example.live_code_loan.mapper.UserResponseMapper;
import com.example.live_code_loan.repository.UserRepository;
import com.example.live_code_loan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse getById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found!");
        }
        return UserResponseMapper.response(
                UserRequest.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .build()
        );
    }
    @Override
    public AppUser loadUserByUserId(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid Credential"));
        return AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().getRole())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user"));
        return AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().getRole())
                .build();
    }

}
