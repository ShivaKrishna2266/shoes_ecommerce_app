package com.shoes_ecommerce_app.services;

import com.shoes_ecommerce_app.DTOs.BrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BrandService {
    List<BrandDTO> getAllBrands();
    Optional<BrandDTO> getBrandById(Long brandId);
    BrandDTO addBrands(BrandDTO brandDTO);
    BrandDTO updateBrand(Long brandId, BrandDTO brandDTO);
    void deleteBrandById(Long brandId);

}
