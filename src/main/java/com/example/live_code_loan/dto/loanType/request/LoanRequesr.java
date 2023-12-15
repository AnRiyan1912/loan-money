package com.example.live_code_loan.dto.loanType.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LoanRequesr {
    private String id;
    private String type;
    private Double maxLoan;
}
