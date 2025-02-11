package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.CategoryDTO;
import com.shoes_ecommerce_app.DTOs.SubCategoryDTO;
import com.shoes_ecommerce_app.entity.Category;
import com.shoes_ecommerce_app.entity.SubCategory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class SubCategoryMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static SubCategoryDTO convertToDTO(SubCategory subCategory){
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        BeanUtils.copyProperties(subCategory ,subCategoryDTO);
        return subCategoryDTO;

    }
    public static SubCategory convertToEntity  (SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = new SubCategory();
        BeanUtils.copyProperties(subCategoryDTO ,subCategory);
        return subCategory;

    }
}
