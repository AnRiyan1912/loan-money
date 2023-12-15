package com.example.live_code_loan.service;

import com.example.live_code_loan.dto.customer.request.CustomerRequest;
import com.example.live_code_loan.dto.customer.response.CustomerResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.dto.instalmentType.request.InstalmentTypeRequest;
import com.example.live_code_loan.dto.instalmentType.response.InstalTypeResponse;
import com.example.live_code_loan.entity.InstalmentType;

import java.util.List;

public interface InstalmentTypeService {
    InstalTypeResponse create(InstalmentType instalmentType);
    InstalTypeResponse update(InstalmentType instalmentType);
    InstalTypeResponse getBYId(String id);
    List<InstalTypeResponse> getAll();
    void remove(String id);


}
