package com.example.live_code_loan.mapper;

import com.example.live_code_loan.dto.customer.request.CustomerRequest;
import com.example.live_code_loan.dto.customer.response.CustomerResponse;
import com.example.live_code_loan.dto.customer.response.CustomerUserResponse;
import com.example.live_code_loan.entity.Customer;
import com.example.live_code_loan.util.DateFormat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class CustomerResponseMapper {
    public static CustomerResponse response(CustomerRequest customerRequest) {
        return CustomerResponse.builder()
                .id(customerRequest.getId())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .dateOfBirth(customerRequest.getDateOfBirth())
                .phone(customerRequest.getPhone())
                .status(customerRequest.getStatus())
                .build();
    }
    public static List<CustomerResponse> responsesList(List<Customer> customerList){
       return customerList.stream().map(customer -> {
            CustomerRequest customerRequest = CustomerRequest.builder()
                    .id(customer.getId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .dateOfBirth(customer.getDateOfBirth().toString())
                    .phone(customer.getPhone())
                    .status(customer.getStatus())
                    .build();
            return CustomerResponse.builder()
                    .id(customerRequest.getId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .dateOfBirth(customer.getDateOfBirth().toString())
                    .phone(customer.getPhone())
                    .status(customer.getStatus())
                    .build();
        }).toList();
    }
    public static CustomerUserResponse responseCustomerUser(CustomerRequest customerRequest) {;
        return CustomerUserResponse.builder()
                .id(customerRequest.getId())
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .dateOfBirth(customerRequest.getDateOfBirth())
                .phone(customerRequest.getPhone())
                .status(customerRequest.getStatus())
                .user(customerRequest.getUser())
                .build();
    }
}
