package com.shoes_ecommerce_app.mapper;

import com.shoes_ecommerce_app.DTOs.ProductDTO;
import com.shoes_ecommerce_app.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product ,productDTO);
        return productDTO;

    }
    public static Product convertToEntity  (ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO ,product);
        return product;

    }
}
