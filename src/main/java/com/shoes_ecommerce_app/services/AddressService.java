package com.shoes_ecommerce_app.services;

import com.shoes_ecommerce_app.DTOs.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<AddressDTO> getAllAddress();
    Optional<AddressDTO> getAddressById(Long addressId);
    AddressDTO addAddress(AddressDTO addressDTO);
    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);
    void deleteAddressById(Long addressId);
}
