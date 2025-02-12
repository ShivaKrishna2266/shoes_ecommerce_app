package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.CustomerDTO;
import com.shoes_ecommerce_app.entity.Customer;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.mapper.CustomerMapper;
import com.shoes_ecommerce_app.repository.CustomerRepository;
import com.shoes_ecommerce_app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .map(CustomerMapper::convertToDTO);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO)throws ApplicationBusinessException {
        try{
            Customer customer = CustomerMapper.convertToEntity(customerDTO);
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setEmail(customerDTO.getEmail());
            customer.setMobileNumber(customerDTO.getMobileNumber());
            customer.setCreatedBy("System");
            customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            customer.setModifiedBy("System");
            customer.setModifiedDate(new Timestamp(System.currentTimeMillis()));

            Customer savedCustomer = customerRepository.save(customer);
            CustomerDTO customerDTO1 = CustomerMapper.convertToDTO(savedCustomer);
            return  customerDTO1;
        }catch (Exception e){
            throw new ApplicationBusinessException("Error while creating Customer", e);
        }
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO)throws  ApplicationBusinessException {
        try{
           Optional<Customer> customerOptional = customerRepository.findById(customerId);
           if (customerOptional.isPresent()){
               Customer customer = customerOptional.get();
               customer.setCustomerName(customerDTO.getCustomerName());
               customer.setEmail(customerDTO.getEmail());
               customer.setMobileNumber(customerDTO.getMobileNumber());
               Customer savedCustomer = customerRepository.save(customer);
               CustomerDTO customerDTO1 = CustomerMapper.convertToDTO(savedCustomer);
               return  customerDTO1;
           }
        }catch (Exception e){
            throw new ApplicationBusinessException("Error while update Customer", e);
        }
        return null;
    }

    @Override
    public void deleteCustomerById(Long customerId) {

    }
}
