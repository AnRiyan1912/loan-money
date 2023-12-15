package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.entity.Admin;
import com.example.live_code_loan.repository.AdminRepository;
import com.example.live_code_loan.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin update(Admin admin) {
        Admin currentAdmin = getById(admin.getId());
        if (currentAdmin == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "admin not found");
        }
        return adminRepository.save(admin);
    }

    @Override
    public Admin getById(String id) {
        Admin currentAdmin = adminRepository.findById(id).orElse(null);
        if (currentAdmin == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "admin not found");
        }
        return currentAdmin;
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public void remove(String id) {
        Admin currentAdmin = getById(id);
        if (currentAdmin != null) {
            adminRepository.delete(currentAdmin);
        }
    }
}
