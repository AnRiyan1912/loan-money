package com.example.live_code_loan.service;

import com.example.live_code_loan.entity.Customer;
import com.example.live_code_loan.entity.Staff;

import java.util.List;

public interface StaffService {
    Staff create(Staff staff);
    Staff update(Staff staff);
    Staff getById(String id);
    List<Staff> getAll();
    void remove(String id);
}
