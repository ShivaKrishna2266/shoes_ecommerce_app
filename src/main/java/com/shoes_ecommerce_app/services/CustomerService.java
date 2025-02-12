package com.shoes_ecommerce_app.services;

import com.shoes_ecommerce_app.DTOs.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(Long customerId);
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO);
    void deleteCustomerById(Long customerId);

}
