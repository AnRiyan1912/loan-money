package com.example.live_code_loan.controller;

import com.example.live_code_loan.constant.AppPath;
import com.example.live_code_loan.dto.commondResponse.CommondResponse;
import com.example.live_code_loan.dto.user.request.UserRequest;
import com.example.live_code_loan.dto.user.response.UserResponse;
import com.example.live_code_loan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.user)
public class UserController {
    private final UserService userService;
    @GetMapping(AppPath.id)
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        UserResponse userResponse = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        CommondResponse.<UserResponse>builder()
                                .statusCode(HttpStatus.OK.value())
                                .message("Success get by id")
                                .data(userResponse)
                                .build()
                );
    }
}
