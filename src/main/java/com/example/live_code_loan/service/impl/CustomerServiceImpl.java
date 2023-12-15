package com.example.live_code_loan.service.impl;

import com.example.live_code_loan.entity.Customer;
import com.example.live_code_loan.repository.CustomerRepository;
import com.example.live_code_loan.service.CustomerService;
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
    public Customer update(Customer customer) {
        Customer currentCustomer = getById(customer.getId());
        if (currentCustomer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void remove(String id) {
        Customer currentCustomer = getById(id);
        if (currentCustomer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
        }
        customerRepository.delete(currentCustomer);
    }
}
