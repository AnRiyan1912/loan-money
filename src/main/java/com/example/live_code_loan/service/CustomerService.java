package com.example.live_code_loan.service;

import com.example.live_code_loan.entity.Customer;
import com.example.live_code_loan.entity.Role;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer getById(String id);
    List<Customer> getAll();
    void remove(String id);
}
