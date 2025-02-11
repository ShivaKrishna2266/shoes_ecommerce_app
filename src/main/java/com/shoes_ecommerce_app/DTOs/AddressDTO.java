package com.shoes_ecommerce_app.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String area;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String region;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private Long customerId;
}
