package com.example.live_code_loan.service;

import com.example.live_code_loan.dto.customer.request.CustomerRequest;
import com.example.live_code_loan.dto.customer.response.CustomerResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    CustomerResponse update(CustomerRequest customerRequest);
    CustomerUserResponse getById(String id);
    List<CustomerResponse> getAll();
    void remove(String id);
}
