package com.example.live_code_loan.dto.commondResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommondResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
}
