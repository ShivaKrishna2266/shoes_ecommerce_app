package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.CategoryDTO;
import com.shoes_ecommerce_app.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class CategoryMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static CategoryDTO convertToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category ,categoryDTO);
        return categoryDTO;

    }
    public static Category convertToEntity  (CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO ,category);
        return category;

    }
}
