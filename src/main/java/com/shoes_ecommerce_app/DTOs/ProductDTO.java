package com.shoes_ecommerce_app.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long productId;
    private String productName;
    private String description;
    private Long categoryId;
    private Long subCategoryId;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIsAvailable;
    private Integer productRank;
    private String productSku;
    private String productInstructions;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;
    private Timestamp modifiedDate;
    private String imageName;
    private String imageURL;
}
