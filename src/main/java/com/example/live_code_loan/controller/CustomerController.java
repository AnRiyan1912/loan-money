package com.example.live_code_loan.controller;

import com.example.live_code_loan.constant.AppPath;
import com.example.live_code_loan.dto.commondResponse.CommondResponse;
import com.example.live_code_loan.dto.customer.request.CustomerRequest;
import com.example.live_code_loan.dto.customer.response.CustomerResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.customer)
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping(AppPath.id)
    public ResponseEntity<?> getCustomerById (@PathVariable String id) {
        CustomerUserResponse customerUserResponse = customerService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.<CustomerUserResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully get customer")
                        .data(customerUserResponse)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomer() {
        List<CustomerResponse> customerResponseList = customerService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                CommondResponse.<List<CustomerResponse>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully fetch user")
                        .data(customerResponseList)
                        .build()

        );
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.update(customerRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                CommondResponse.<CustomerResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully update customer")
                        .data(customerResponse)
                        .build()

        );

    }
    @PreAuthorize("hasRole('ROLE_ADMIN' or 'ROLE_STAFF')")
    @DeleteMapping(AppPath.id)
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        customerService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                CommondResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully delete customer")
                        .build()

        );
    }
}
