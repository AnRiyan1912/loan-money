package com.example.live_code_loan.service;

import com.example.live_code_loan.entity.Role;

import java.util.List;

public interface RoleService {
    Role create(Role role);
    Role update(Role role);
    Role getById(String id);
    List<Role> getAll();
    void remove(String id);
    Role getOrSave(Role role);
}
