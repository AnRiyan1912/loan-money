package com.example.live_code_loan.service;

import com.example.live_code_loan.dto.loanType.response.LoanResponse;
import com.example.live_code_loan.entity.LoanType;

import java.util.List;

public interface LoanTypesServices {
    LoanResponse create(LoanType loanType);
    LoanResponse update(LoanType loanType);
    LoanResponse getBYId(String id);
    List<LoanResponse> getAll();
    void remove(String id);
}
