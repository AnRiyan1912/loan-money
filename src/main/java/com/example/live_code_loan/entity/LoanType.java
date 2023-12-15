package com.example.live_code_loan.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "m_loan_type")
public class LoanType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true, nullable = false, length = 50)
    private String type;
    @Column(name = "max_loan", nullable = false)
    private Double maxLoan;
    @OneToMany(mappedBy = "loanType")
    private List<LoanTransaction> loanTransactionList;
}
