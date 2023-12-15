package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.entity.Role;
import com.example.live_code_loan.repository.RoleRepository;
import com.example.live_code_loan.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
       Role currentRole = roleRepository.getById(role.getId());
       if (currentRole == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
       }
        return  roleRepository.save(role);
    }

    @Override
    public Role getById(String id) {
        Role currentRole = roleRepository.findById(id).orElse(null);
        if(currentRole == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return currentRole;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void remove(String id) {
        Role currentRole = getById(id);
        if (currentRole == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        roleRepository.delete(currentRole);
    }

    @Override
    public Role getOrSave(Role role) {
        Optional<Role> currentRole = roleRepository.findByRole(role.getRole());
        if (!currentRole.isEmpty()){
            return currentRole.get();
        }
        return roleRepository.saveAndFlush(role);
    }
}
