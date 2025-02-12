package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.CategoryDTO;
import com.shoes_ecommerce_app.entity.Brand;
import com.shoes_ecommerce_app.entity.Category;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.mapper.CategoryMapper;
import com.shoes_ecommerce_app.repository.BrandRepository;
import com.shoes_ecommerce_app.repository.CategoryRepository;
import com.shoes_ecommerce_app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Long categoryId) {
        return categoryRepository
                .findById(categoryId)
                .map(CategoryMapper::convertToDTO);
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) throws ApplicationBusinessException {
        try {
            Category category = CategoryMapper.convertToEntity(categoryDTO);
            category.setCategoryName(categoryDTO.getCategoryName());
            category.setTagline(categoryDTO.getCategoryTagline());
            category.setDescription(categoryDTO.getDescription());
            category.setCreatedBy("System");
            category.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            category.setUpdatedBy("System");
            category.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

            Optional<Brand> brandOptional = brandRepository.findById(categoryDTO.getBrandId());
            brandOptional.ifPresent(category::setBrand);

            Category savedCategory = categoryRepository.save(category);
            CategoryDTO categoryDTO1 = CategoryMapper.convertToDTO(savedCategory);
            categoryDTO1.setBrandId(category.getBrand().getBrandId());
            return categoryDTO1;
        } catch (Exception e) {
            throw new ApplicationBusinessException("Error while creating Category", e);
        }

    }


    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO)throws  ApplicationBusinessException {
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
            if(optionalCategory.isPresent()){
                Category category = optionalCategory.get();
                category.setCategoryName(categoryDTO.getCategoryName());
                category.setTagline(categoryDTO.getCategoryTagline());
                category.setDescription(categoryDTO.getDescription());

                Optional<Brand> brandOptional = brandRepository.findById(categoryDTO.getBrandId());
                brandOptional.ifPresent(category::setBrand);

                Category savedCategory = categoryRepository.save(category);
                CategoryDTO categoryDTO1 =  CategoryMapper.convertToDTO(savedCategory);
                return  categoryDTO1;
            }
        } catch (Exception e){
            throw new ApplicationBusinessException("Error while update Category", e);
        }
        return null;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {

    }
}
