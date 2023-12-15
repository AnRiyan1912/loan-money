package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.dto.customer.request.CustomerRequest;
import com.example.live_code_loan.dto.customer.response.CustomerResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.entity.Customer;
import com.example.live_code_loan.mapper.CustomerResponseMapper;
import com.example.live_code_loan.repository.CustomerRepository;
import com.example.live_code_loan.service.CustomerService;
import com.example.live_code_loan.util.DateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest) {
        CustomerUserResponse customerResponse = getById(customerRequest.getId());
        if (customerResponse == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        Customer saveCustomer = customerRepository.save(Customer.builder()
                        .id(customerRequest.getId())
                        .firstName(customerRequest.getFirstName())
                        .lastName(customerRequest.getLastName())
                        .dateOfBirth(DateFormat.formatStringToDate(customerRequest.getDateOfBirth()))
                        .phone(customerRequest.getPhone())
                        .status(customerRequest.getStatus())
                        .user(customerResponse.getUser())
                .build());
        return CustomerResponseMapper.response(CustomerRequest.builder()
                        .id(saveCustomer.getId())
                        .firstName(saveCustomer.getFirstName())
                        .lastName(saveCustomer.getLastName())
                        .dateOfBirth(saveCustomer.getDateOfBirth().toString())
                        .phone(saveCustomer.getPhone())
                        .status(saveCustomer.getStatus()).

                build());
    }

    @Override
    public CustomerUserResponse getById(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }

        return CustomerResponseMapper.responseCustomerUser(CustomerRequest.builder()
                        .id(customer.getId())
                        .dateOfBirth(customer.getDateOfBirth().toString())
                        .phone(customer.getPhone())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .status(customer.getStatus())
                        .user(customer.getUser())
                .build());
    }

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        return CustomerResponseMapper.responsesList(customerList);
    }

    @Override
    public void remove(String id) {
        CustomerUserResponse customerUserResponse = getById(id);
        if (customerUserResponse != null) {
          customerRepository.save(Customer.builder()
                    .id(customerUserResponse.getId())
                    .firstName(customerUserResponse.getFirstName())
                    .lastName(customerUserResponse.getLastName())
                    .phone(customerUserResponse.getPhone())
                    .dateOfBirth(DateFormat.formatStringToDate(customerUserResponse.getDateOfBirth()))
                    .phone(customerUserResponse.getPhone())
                    .user(customerUserResponse.getUser())
                    .status("not active")
                    .build());
            System.out.println("success delete");
        }
    }
}
