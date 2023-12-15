package com.example.live_code_loan.service;

import com.example.live_code_loan.dto.auth.request.AuthRequest;
import com.example.live_code_loan.dto.auth.request.LoginRequest;
import com.example.live_code_loan.dto.auth.response.LoginResponse;
import com.example.live_code_loan.dto.auth.response.RegisterResponse;

public interface AuthService {
    RegisterResponse registerCustomer(AuthRequest authRequest);
    RegisterResponse registerAdmin(AuthRequest authRequest);
    RegisterResponse registerStaff(AuthRequest authRequest);
    LoginResponse login(LoginRequest loginRequest);

}
