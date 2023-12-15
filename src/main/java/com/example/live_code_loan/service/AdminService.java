package com.example.live_code_loan.service;

import com.example.live_code_loan.entity.Admin;
import com.example.live_code_loan.entity.Customer;

import java.util.List;

public interface AdminService {

    Admin create(Admin admin);
    Admin update(Admin admin);
    Admin getById(String id);
    List<Admin> getAll();
    void remove(String id);
}
