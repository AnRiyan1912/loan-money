package com.example.live_code_loan.controller;

import com.example.live_code_loan.constant.AppPath;
import com.example.live_code_loan.service.LoanTypesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.instalmentType)
public class LoanTypeController {
    private final LoanTypesServices loanTypesServices;


}
