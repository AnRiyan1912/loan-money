package com.example.live_code_loan.service;

import com.example.live_code_loan.dto.user.request.UserRequest;
import com.example.live_code_loan.dto.user.response.UserResponse;
import com.example.live_code_loan.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    AppUser loadUserByUserId(String email);
    UserResponse getById(String  id);

}
