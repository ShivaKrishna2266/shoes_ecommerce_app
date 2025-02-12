package com.shoes_ecommerce_app.services;
import com.shoes_ecommerce_app.DTOs.SubCategoryDTO;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    List<SubCategoryDTO> getAllSubCategories();
    Optional<SubCategoryDTO> getSubCategoryById(Long subCategoryId);
    SubCategoryDTO addSubCategory(SubCategoryDTO subCategoryDTO);
    SubCategoryDTO updateSubCategory(Long subCategoryId, SubCategoryDTO subCategoryDTO);
    void deleteSubCategoryById (Long subCategoryId);
}
