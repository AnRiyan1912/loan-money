package com.example.live_code_loan.repository;

import com.example.live_code_loan.constant.ERole;
import com.example.live_code_loan.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String > {
    Optional<Role> findByRole(ERole role);
}
