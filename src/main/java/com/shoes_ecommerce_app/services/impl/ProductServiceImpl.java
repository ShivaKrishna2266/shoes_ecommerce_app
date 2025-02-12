package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.ProductDTO;
import com.shoes_ecommerce_app.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public Optional<ProductDTO> getProductById(Long productId) {
        return Optional.empty();
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
