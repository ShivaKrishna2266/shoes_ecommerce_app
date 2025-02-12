package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.AddressDTO;
import com.shoes_ecommerce_app.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public List<AddressDTO> getAllAddress() {
        return null;
    }

    @Override
    public Optional<AddressDTO> getAddressById(Long addressId) {
        return Optional.empty();
    }

    @Override
    public AddressDTO addAddress(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
        return null;
    }

    @Override
    public void deleteAddressById(Long addressId) {

    }
}
