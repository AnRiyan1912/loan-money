package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.entity.Staff;
import com.example.live_code_loan.repository.StaffRepository;
import com.example.live_code_loan.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        Staff currentStaff = getById(staff.getId());
        if (currentStaff!=null) {
            return staffRepository.save(staff);
        }
        return null;
    }

    @Override
    public Staff getById(String id) {
        Staff staff = staffRepository.findById(id).orElse(null);
        if (staff == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "staff not found");
        }
        return staff;
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public void remove(String id) {
        Staff staff = getById(id);
        if (staff!=null) {
           staffRepository.save(Staff.builder()
                           .id(staff.getId())
                           .firstName(staff.getFirstName())
                           .lastName(staff.getLastName())
                           .phone(staff.getPhone())
                           .user(staff.getUser())
                           .status("not active")
                   .build());
        }

    }
}
