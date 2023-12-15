package com.example.live_code_loan.controller;

import com.example.live_code_loan.constant.AppPath;
import com.example.live_code_loan.dto.auth.request.AuthRequest;
import com.example.live_code_loan.dto.auth.request.LoginRequest;
import com.example.live_code_loan.dto.auth.response.LoginResponse;
import com.example.live_code_loan.dto.auth.response.RegisterResponse;
import com.example.live_code_loan.dto.commondResponse.CommondResponse;
import com.example.live_code_loan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.auth)
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/register/customer")
    public ResponseEntity<?> registerCustomer (@RequestBody AuthRequest authRequest) {
        RegisterResponse registerResponse = authService.registerCustomer(authRequest);
                return ResponseEntity.status(HttpStatus.CREATED).body(
                        CommondResponse.<RegisterResponse>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .message("Successfully registered")
                                .data(registerResponse)
                                .build()
                );
    }
    @PostMapping(value = "/register/admin")
    public ResponseEntity<?> registerAdmin (@RequestBody AuthRequest authRequest) {
        RegisterResponse registerResponse = authService.registerAdmin(authRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<RegisterResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully registered")
                        .data(registerResponse)
                        .build()
        );
    }
    @PostMapping(value = "/register/staff")
    public ResponseEntity<?> registerStaff (@RequestBody AuthRequest authRequest) {
        RegisterResponse registerResponse = authService.registerStaff(authRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<RegisterResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully registered")
                        .data(registerResponse)
                        .build()
        );
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<LoginResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully registered")
                        .data(loginResponse)
                        .build()
        );
    }
}
