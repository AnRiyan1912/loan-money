package com.example.live_code_loan.entity;

import com.example.live_code_loan.constant.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Password is mandatory")
    private ERole role;
    @OneToMany(mappedBy = "role")
    private List<User> user;
}
