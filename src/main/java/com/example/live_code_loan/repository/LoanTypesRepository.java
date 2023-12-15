package com.example.live_code_loan.repository;

import com.example.live_code_loan.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypesRepository extends JpaRepository<LoanType, String> {
}
