package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.SubCategoryDTO;
import com.shoes_ecommerce_app.services.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Override
    public List<SubCategoryDTO> getAllSubCategories() {
        return null;
    }

    @Override
    public Optional<SubCategoryDTO> getSubCategoryById(Long subCategoryId) {
        return Optional.empty();
    }

    @Override
    public SubCategoryDTO addSubCategory(SubCategoryDTO subCategoryDTO) {
        return null;
    }

    @Override
    public SubCategoryDTO updateSubCategory(Long subCategoryId, SubCategoryDTO subCategoryDTO) {
        return null;
    }

    @Override
    public void deleteSubCategoryById(Long subCategoryId) {

    }
}
