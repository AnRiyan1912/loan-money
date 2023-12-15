package com.example.live_code_loan.entity;

import com.example.live_code_loan.constant.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "trx_loan_detail")
public class LoanTransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "transaction_date", nullable = false)
    private Long trasactionDate;
    @Column(nullable = false)
    private Double nominal;
    @Column(nullable = false)
    private LoanStatus loanStatus;
    @Column(nullable = false)
    private Long craetedAt;
    @Column(nullable = false)
    private Long updatedAt;
    @ManyToOne
    @JoinColumn(name = "trx_loan_id")
    private LoanTransaction loanTransaction;
}
