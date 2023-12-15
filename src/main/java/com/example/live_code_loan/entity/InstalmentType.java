package com.example.live_code_loan.entity;

import com.example.live_code_loan.constant.EInstalmentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "m_instalment_type")
public class InstalmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "instalment_type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private EInstalmentType instalmentType;
    @OneToMany(mappedBy = "instalmentType")
    private List<LoanTransaction> loanTransactionList;
}
