package com.shoes_ecommerce_app.controller;

import com.shoes_ecommerce_app.DTOs.BrandDTO;
import com.shoes_ecommerce_app.entity.ApiResponse;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/getAllBrands")
    public ResponseEntity<ApiResponse<List<BrandDTO>>> getAllBrands() {
        ApiResponse<List<BrandDTO>> response = new ApiResponse<>();
        try {
            List<BrandDTO> brandDTOS = brandService.getAllBrands();
            if(brandDTOS != null) {
                response.setStatus(200);
                response.setMessage("Fetched all Brands successfully!");
                response.setData(brandDTOS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to fetch all Brands!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to fetch carModels!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
