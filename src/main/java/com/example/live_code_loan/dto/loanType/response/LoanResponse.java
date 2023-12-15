package com.example.live_code_loan.dto.loanType.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoanResponse {
    private String id;
    private String type;
    private Double maxLoan;
}
