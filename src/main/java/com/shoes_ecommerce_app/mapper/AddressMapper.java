package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.AddressDTO;
import com.shoes_ecommerce_app.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class AddressMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static AddressDTO convertToDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(address ,addressDTO);
        return addressDTO;

    }
    public static Address convertToEntity  (AddressDTO addressDTO) {
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO ,address);
        return address;

    }
}
