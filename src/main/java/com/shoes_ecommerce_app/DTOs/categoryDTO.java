package com.shoes_ecommerce_app.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class categoryDTO {
    private Long categoryId;
    private String categoryName;
    private String description;
    private String categoryTagline;
    private String  brandName;
}
