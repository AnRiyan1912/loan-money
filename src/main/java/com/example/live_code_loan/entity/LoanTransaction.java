package com.example.live_code_loan.entity;

import com.example.live_code_loan.constant.ApprovalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "trx_loan")
public class LoanTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private Double nominal;
    @Column(nullable = false)
    private Long approvedAt;
    @Column(nullable = false)
    private String approvedBy;
    @Column(name = "approval_status", nullable = false)
    private ApprovalStatus approvalStatus;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "instalment_type_id")
    private InstalmentType instalmentType;
    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    private LoanType loanType;
    @OneToMany(mappedBy = "loanTransaction")
    private List<LoanTransactionDetail> loanTransactionDetails;
}
