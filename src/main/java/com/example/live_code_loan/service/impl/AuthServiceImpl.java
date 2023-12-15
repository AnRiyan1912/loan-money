package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.constant.ERole;
import com.example.live_code_loan.dto.auth.request.AuthRequest;
import com.example.live_code_loan.dto.auth.request.LoginRequest;
import com.example.live_code_loan.dto.auth.response.LoginResponse;
import com.example.live_code_loan.dto.auth.response.RegisterResponse;
import com.example.live_code_loan.entity.*;
import com.example.live_code_loan.repository.UserRepository;
import com.example.live_code_loan.security.JwtUtils;
import com.example.live_code_loan.service.*;
import com.example.live_code_loan.util.DateFormat;
import com.example.live_code_loan.util.ValidationUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;
    private final AdminService adminService;
    private final StaffService staffService;
    private final ValidationUtil validationUtil;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Transactional(rollbackOn = Exception.class)
    @Override
    public RegisterResponse registerCustomer(AuthRequest authRequest) {
        try{
            Role role = roleService.getOrSave(Role.builder()
                    .role(ERole.ROLE_CUSTOMER)
                    .build());
            User user = userRepository.saveAndFlush(User.builder()
                    .email(authRequest.getEmail())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build());

            customerService.create(Customer.builder()
                    .firstName(authRequest.getFirstName())
                    .lastName(authRequest.getLastName())
                    .phone(authRequest.getPhone())
                    .dateOfBirth(DateFormat.formatStringToDate(authRequest.getBirthDate()))
                    .status("active")
                    .user(user)
                    .build());

            return RegisterResponse.builder()
                    .email(user.getEmail())
                    .role(role.getRole().name())
                    .build();

        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User alredy exist");
        }

    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest authRequest) {
        try{
            Role role = roleService.getOrSave(Role.builder()
                    .role(ERole.ROLE_ADMIN)
                    .build());
            User user = userRepository.saveAndFlush(User.builder()
                    .email(authRequest.getEmail())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build());
            adminService.create(Admin.builder()
                            .firstName(authRequest.getFirstName())
                            .lastName(authRequest.getLastName())
                            .phone(authRequest.getPhone())
                            .user(user)
                            .dateOfBirth(DateFormat.formatStringToDate(authRequest.getBirthDate()))
                            .status("active")
                    .build());

            return RegisterResponse.builder()
                    .email(user.getEmail())
                    .role(role.getRole().name())
                    .build();

        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User alredy exist");
        }
    }

    @Override
    public RegisterResponse registerStaff(AuthRequest authRequest) {
        try{
            Role role = roleService.getOrSave(Role.builder()
                    .role(ERole.ROLE_STAFF)
                    .build());
            User user = userRepository.saveAndFlush(User.builder()
                    .email(authRequest.getEmail())
                    .password(passwordEncoder.encode(authRequest.getPassword()))
                    .role(role)
                    .build());
            staffService.create(Staff.builder()
                            .firstName(authRequest.getFirstName())
                            .lastName(authRequest.getLastName())
                            .phone(authRequest.getPhone())
                            .dateOfBirth(DateFormat.formatStringToDate(authRequest.getBirthDate()))
                            .status("active")
                            .user(user)
                    .build());

            return RegisterResponse.builder()
                    .email(user.getEmail())
                    .role(role.getRole().name())
                    .build();

        }catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User alredy exist");
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        validationUtil.validate(loginRequest);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail().toLowerCase(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AppUser appUser = (AppUser) authentication.getPrincipal();
        String token = jwtUtils.generateToken(appUser);
        return LoginResponse.builder()
                .email(appUser.getEmail())
                .token(token)
                .role(appUser.getRole().name())
                .build();
    }
}
