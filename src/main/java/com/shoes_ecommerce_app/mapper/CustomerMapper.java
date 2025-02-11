package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.CustomerDTO;
import com.shoes_ecommerce_app.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class CustomerMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static CustomerDTO convertToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer ,customerDTO);
        return customerDTO;

    }
    public static Customer convertToEntity  (CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO ,customer);
        return customer;

    }
}
