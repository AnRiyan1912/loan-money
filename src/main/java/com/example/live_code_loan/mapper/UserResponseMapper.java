package com.example.live_code_loan.mapper;

import com.example.live_code_loan.dto.user.request.UserRequest;
import com.example.live_code_loan.dto.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserResponseMapper {
    public static UserResponse response(UserRequest userRequest) {
        return UserResponse.builder()
                .email(userRequest.getEmail())
                .role(userRequest.getRole().getRole().name())
                .build();
    }
}
