package com.shoes_ecommerce_app.services.impl;

import com.shoes_ecommerce_app.DTOs.ProductDTO;
import com.shoes_ecommerce_app.entity.Category;
import com.shoes_ecommerce_app.entity.Product;
import com.shoes_ecommerce_app.entity.SubCategory;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.mapper.ProductMapper;
import com.shoes_ecommerce_app.repository.CategoryRepository;
import com.shoes_ecommerce_app.repository.ProductRepository;
import com.shoes_ecommerce_app.repository.SubCategoryRepository;
import com.shoes_ecommerce_app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Long productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::convertToDTO);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO)throws ApplicationBusinessException {

            Product product = ProductMapper.convertToEntity(productDTO);
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());
            product.setDescription(productDTO.getDescription());
            product.setImageName(productDTO.getImageName());
            product.setImageURL(productDTO.getImageURL());
            product.setProductInstructions(productDTO.getProductInstructions());
            product.setProductQuantity(productDTO.getProductQuantity());
            product.setProductRank(productDTO.getProductRank());
            product.setProductSku(productDTO.getProductSku());

            Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
            categoryOptional.ifPresent(product::setCategoryId);

            Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(productDTO.getSubCategoryId());
            subCategoryOptional.ifPresent(product::setSubCategoryId);

            Product savedProduct = productRepository.save(product);
            ProductDTO productDTO1 = ProductMapper.convertToDTO(savedProduct);
//            productDTO1.setCategoryId(product.getCategoryId());
//            productDTO1.setSubCategoryId(product.getSubCategoryId());
           return productDTO1;

    }

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO)throws  ApplicationBusinessException {
        try{
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                product.setProductName(productDTO.getProductName());
                product.setProductPrice(productDTO.getProductPrice());
                product.setDescription(productDTO.getDescription());
                product.setProductInstructions(productDTO.getProductInstructions());
                product.setProductQuantity(productDTO.getProductQuantity());
                product.setImageName(productDTO.getImageName());

                Optional<Category> categoryOptional = categoryRepository.findById(productDTO.getCategoryId());
                categoryOptional.ifPresent(product::setCategoryId);

                Optional<SubCategory> subCategoryOptional = subCategoryRepository.findById(productDTO.getSubCategoryId());
                subCategoryOptional.ifPresent(product::setSubCategoryId);

                Product savedProduct = productRepository.save(product);
               ProductDTO productDTO1 = ProductMapper.convertToDTO(savedProduct);
               return  productDTO1;
            }
        }catch (Exception e){
            throw new ApplicationBusinessException("Error while update Product", e);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
