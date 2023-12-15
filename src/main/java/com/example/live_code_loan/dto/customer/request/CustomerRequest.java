package com.example.live_code_loan.dto.customer.request;

import com.example.live_code_loan.entity.LoanTransaction;
import com.example.live_code_loan.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phone;
    private String status;
    private User user;
}
