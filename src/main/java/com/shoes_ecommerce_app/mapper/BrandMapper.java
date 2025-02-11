package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.BrandDTO;
import com.shoes_ecommerce_app.entity.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class BrandMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static BrandDTO convertToDTO(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        BeanUtils.copyProperties(brand ,brandDTO);
        return brandDTO;

    }
    public static Brand convertToEntity  (BrandDTO brandDTO) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandDTO ,brand);
        return brand;

    }
}
