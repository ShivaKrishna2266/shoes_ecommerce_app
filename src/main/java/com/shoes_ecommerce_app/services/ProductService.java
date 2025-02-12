package com.shoes_ecommerce_app.services;

import com.shoes_ecommerce_app.DTOs.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long productId);
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long productId, ProductDTO productDTO);
    void deleteProduct(Long productId);


}
