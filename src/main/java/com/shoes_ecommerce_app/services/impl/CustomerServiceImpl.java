package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.CustomerDTO;
import com.shoes_ecommerce_app.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long customerId) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomerById(Long customerId) {

    }
}
