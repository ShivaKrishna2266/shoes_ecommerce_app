package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.BrandDTO;
import com.shoes_ecommerce_app.entity.Brand;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.mapper.BrandMapper;
import com.shoes_ecommerce_app.repository.BrandRepository;
import com.shoes_ecommerce_app.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl  implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<BrandDTO> getAllBrands() {
        return  brandRepository.findAll()
                .stream()
                .map(BrandMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDTO> getBrandById(Long brandId) {
        return brandRepository.findById(brandId)
                .map(BrandMapper::convertToDTO);
    }

    @Override
    public BrandDTO addBrands(BrandDTO brandDTO)throws ApplicationBusinessException {
        try {
            Brand brand = BrandMapper.convertToEntity(brandDTO);
            brand.setBrandName(brandDTO.getBrandName());
            brand.setBrandDescription(brandDTO.getBrandDescription());
            brand.setBrandTagline(brandDTO.getBrandTagline());
            brand.setImageName(brandDTO.getImageName());
            brand.setImageURL(brandDTO.getImageURL());
            brand.setCreatedBy("System");
            brand.setCreatedDate(new Timestamp(System.currentTimeMillis()));
                brand.setModifiedBy("System");
                brand.setModifiedDate(new Timestamp(System.currentTimeMillis()));
            Brand savedBrand = brandRepository.save(brand);
            BrandDTO brandDTO1 =  BrandMapper.convertToDTO(savedBrand);
            return  brandDTO1;
            } catch (Exception e) {
                    throw new ApplicationBusinessException("Error while creating Brand", e);
                }
    }

    @Override
    public BrandDTO updateBrand(Long brandId, BrandDTO brandDTO)throws ApplicationBusinessException {
        try {
            Optional<Brand> optionalBrand = brandRepository.findById(brandId);
            if (optionalBrand.isPresent()) {
                Brand brand = optionalBrand.get();
                brand.setBrandName(brandDTO.getBrandName());
                brand.setBrandDescription(brandDTO.getBrandDescription());
                brand.setBrandTagline(brandDTO.getBrandTagline());
                brand.setImageName(brandDTO.getImageName());
                brand.setImageURL(brandDTO.getImageURL());
                Brand savedBrand = brandRepository.save(brand);
                BrandDTO brandDTO1 = BrandMapper.convertToDTO(savedBrand);
                return brandDTO1;
            }
        } catch (Exception e) {
            throw new ApplicationBusinessException("Error while Update carBrand", e);
        }
        return null;
    }


    @Override
    public void deleteBrandById(Long brandId) {

    }
}
