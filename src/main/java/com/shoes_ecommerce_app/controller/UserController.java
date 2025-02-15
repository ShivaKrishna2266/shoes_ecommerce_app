package com.shoes_ecommerce_app.controller;

import com.shoes_ecommerce_app.DTOs.BrandDTO;
import com.shoes_ecommerce_app.DTOs.CategoryDTO;
import com.shoes_ecommerce_app.DTOs.CustomerDTO;
import com.shoes_ecommerce_app.DTOs.ProductDTO;
import com.shoes_ecommerce_app.DTOs.SubCategoryDTO;
import com.shoes_ecommerce_app.entity.ApiResponse;
import com.shoes_ecommerce_app.execption.ApplicationBusinessException;
import com.shoes_ecommerce_app.services.BrandService;
import com.shoes_ecommerce_app.services.CategoryService;
import com.shoes_ecommerce_app.services.CustomerService;
import com.shoes_ecommerce_app.services.ProductService;
import com.shoes_ecommerce_app.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SubCategoryService subCategoryService;

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


    @GetMapping("/getBrandById/{brandId}")
    public ResponseEntity<ApiResponse<BrandDTO>> getBrandById(@PathVariable Long brandId) {
        ApiResponse<BrandDTO> response = new ApiResponse<>();

        Optional<BrandDTO> brandDTOOptional = brandService.getBrandById(brandId);

        if (brandDTOOptional.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Record fetched successfully");
            response.setData(brandDTOOptional.get());
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Brand not found with ID: " + brandId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }




    @PostMapping("/addBrand")
    public ResponseEntity<ApiResponse<BrandDTO>> addBrand(@RequestBody BrandDTO brandDTO) {
        ApiResponse<BrandDTO> response = new ApiResponse<>();
        try {
            BrandDTO addBrandDTO = brandService.addBrands(brandDTO);
            if (addBrandDTO != null) {
                response.setStatus(200);
                response.setMessage("Successfully added a brand!");
                response.setData(addBrandDTO);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to add a brand!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to add a carModel!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateBrand/{brandId}")
    public ResponseEntity<ApiResponse<BrandDTO>> updateBrand(@PathVariable Long brandId, @RequestBody BrandDTO  brandDTO) {
        ApiResponse<BrandDTO> response = new ApiResponse<>();
        try {
            BrandDTO updatebrandDTO = brandService.updateBrand(brandId, brandDTO);
            if (updatebrandDTO != null) {
                response.setStatus(200);
                response.setMessage("Successfully updated a Brand!");
                response.setData(updatebrandDTO);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to update a Brand!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to update a carModel!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBrand/{brandId}")
    public ResponseEntity<ApiResponse<Void>> deleteBrand(@PathVariable Long brandId) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            brandService.deleteBrandById(brandId);
            if (brandId != null) {
                response.setStatus(200);
                response.setMessage("Successfully deleted a brand!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to delete a Brand!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to delete a carModel!" + ae.getMessage());
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//===================Category=====================================//


    @GetMapping("/getAllCategories")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        ApiResponse<List<CategoryDTO>> response = new ApiResponse<>();
        try {
            List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
            if(categoryDTOS != null) {
                response.setStatus(200);
                response.setMessage("Fetched all Categories successfully!");
                response.setData(categoryDTOS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to fetch all Categories!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to fetch Categories!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getCategoryById/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryDTO>> getCategoryById(@PathVariable Long categoryId) {
        ApiResponse<CategoryDTO> response = new ApiResponse<>();

        Optional<CategoryDTO> categoryDTOOptional = categoryService.getCategoryById(categoryId);

        if (categoryDTOOptional.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Record fetched successfully");
            response.setData(categoryDTOOptional.get());
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Brand not found with ID: " + categoryId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }




    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO categoryDTO) {
        ApiResponse<CategoryDTO> response = new ApiResponse<>();
        try {
            CategoryDTO addCategory = categoryService.addCategory(categoryDTO);
            if (addCategory != null) {
                response.setStatus(200);
                response.setMessage("Successfully added a Category!");
                response.setData(addCategory);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to add a Category!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to add a Category!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryDTO>> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO  categoryDTO) {
        ApiResponse<CategoryDTO> response = new ApiResponse<>();
        try {
            CategoryDTO updateCategory = categoryService.updateCategory(categoryId, categoryDTO);
            if (updateCategory != null) {
                response.setStatus(200);
                response.setMessage("Successfully updated a Category!");
                response.setData(updateCategory);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to update a Category!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to update a Category!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long categoryId) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            categoryService.deleteCategoryById(categoryId);
            if (categoryId != null) {
                response.setStatus(200);
                response.setMessage("Successfully deleted a category!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to delete a category!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to delete a category!" + ae.getMessage());
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //=================Customer====================//


    @GetMapping("/getAllCustomer")
    public ResponseEntity<ApiResponse<List<CustomerDTO>>> getAllCustomer() {
        ApiResponse<List<CustomerDTO>> response = new ApiResponse<>();
        try {
            List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
            if(customerDTOS != null) {
                response.setStatus(200);
                response.setMessage("Fetched all Customer successfully!");
                response.setData(customerDTOS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to fetch all Customer!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to fetch Customer!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDTO>> getCustomerById(@PathVariable Long customerId) {
        ApiResponse<CustomerDTO> response = new ApiResponse<>();

        Optional<CustomerDTO> customerDTOOptional = customerService.getCustomerById(customerId);

        if (customerDTOOptional.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Record fetched successfully");
            response.setData(customerDTOOptional.get());
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Brand not found with ID: " + customerId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }




    @PostMapping("/addCustomer")
    public ResponseEntity<ApiResponse<CustomerDTO>> addCustomer(@RequestBody CustomerDTO customerDTO) {
        ApiResponse<CustomerDTO> response = new ApiResponse<>();
        try {
            CustomerDTO addCustomer = customerService.addCustomer(customerDTO);
            if (addCustomer != null) {
                response.setStatus(200);
                response.setMessage("Successfully added a Customer!");
                response.setData(addCustomer);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to add a Customer!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to add a Customer!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<ApiResponse<CustomerDTO>> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO  customerDTO) {
        ApiResponse<CustomerDTO> response = new ApiResponse<>();
        try {
            CustomerDTO updateCustomer = customerService.updateCustomer(customerId, customerDTO);
            if (updateCustomer != null) {
                response.setStatus(200);
                response.setMessage("Successfully updated a Customer!");
                response.setData(updateCustomer);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to update a Customer!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to update a Customer!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Long customerId) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            customerService.deleteCustomerById(customerId);
            if (customerId != null) {
                response.setStatus(200);
                response.setMessage("Successfully deleted a Customer!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to delete a Customer!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to delete a Customer!" + ae.getMessage());
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //================Product===============================//


    @GetMapping("/getAllProduct")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProduct() {
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
        try {
            List<ProductDTO> productDTOS = productService.getAllProducts();
            if(productDTOS != null) {
                response.setStatus(200);
                response.setMessage("Fetched all Product successfully!");
                response.setData(productDTOS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to fetch all Product!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to fetch Product!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ApiResponse<ProductDTO>>getProductById(@PathVariable Long productId) {
        ApiResponse<ProductDTO> response = new ApiResponse<>();

        Optional<ProductDTO> productDTOOptional = productService.getProductById(productId);

        if (productDTOOptional.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Record fetched successfully");
            response.setData(productDTOOptional.get());
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Brand not found with ID: " + productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }




    @PostMapping("/addProduct")
    public ResponseEntity<ApiResponse<ProductDTO>> addProduct(@RequestBody ProductDTO productDTO) {
        ApiResponse<ProductDTO> response = new ApiResponse<>();
        try {
            ProductDTO addProduct = productService.addProduct(productDTO);
            if (addProduct != null) {
                response.setStatus(200);
                response.setMessage("Successfully added a Product!");
                response.setData(addProduct);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to add a Product!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to add a Product!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO  productDTO) {
        ApiResponse<ProductDTO> response = new ApiResponse<>();
        try {
            ProductDTO updateProduct = productService.updateProduct(productId, productDTO);
            if (updateProduct != null) {
                response.setStatus(200);
                response.setMessage("Successfully updated a Product!");
                response.setData(updateProduct);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to update a Product!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to update a Product!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProductById/{productId}")
    public ResponseEntity<ApiResponse<Void>> deleteProductById(@PathVariable Long productId) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            productService.deleteProduct(productId);
            if (productId != null) {
                response.setStatus(200);
                response.setMessage("Successfully deleted a Product!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to delete a Product!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to delete a Product!" + ae.getMessage());
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //=======================SubCategory===============================//


    @GetMapping("/getAllSubCategory")
    public ResponseEntity<ApiResponse<List<SubCategoryDTO>>> getAllSubCategory() {
        ApiResponse<List<SubCategoryDTO>> response = new ApiResponse<>();
        try {
            List<SubCategoryDTO> subCategoryDTOS = subCategoryService.getAllSubCategories();
            if(subCategoryDTOS != null) {
                response.setStatus(200);
                response.setMessage("Fetched all SubCategory successfully!");
                response.setData(subCategoryDTOS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to fetch all SubCategory!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to fetch SubCategory!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getSubCategoryById/{subCategoryId}")
    public ResponseEntity<ApiResponse<SubCategoryDTO>>getSubCategoryById(@PathVariable Long subCategoryId) {
        ApiResponse<SubCategoryDTO> response = new ApiResponse<>();

        Optional<SubCategoryDTO> subCategoryDTO = subCategoryService.getSubCategoryById(subCategoryId);

        if (subCategoryDTO.isPresent()) {
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Record fetched successfully");
            response.setData(subCategoryDTO.get());
            return ResponseEntity.ok(response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Brand not found with ID: " + subCategoryId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }




    @PostMapping("/addSubCategory")
    public ResponseEntity<ApiResponse<SubCategoryDTO>> addSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
        ApiResponse<SubCategoryDTO> response = new ApiResponse<>();
        try {
            SubCategoryDTO addSubCategory = subCategoryService.addSubCategory(subCategoryDTO);
            if (addSubCategory != null) {
                response.setStatus(200);
                response.setMessage("Successfully added a SubCategory!");
                response.setData(addSubCategory);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to add a SubCategory!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to add a SubCategory!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateSubCategory/{subCategoryId}")
    public ResponseEntity<ApiResponse<SubCategoryDTO>> updateSubCategory(@PathVariable Long subCategoryId, @RequestBody SubCategoryDTO  subCategoryDTO) {
        ApiResponse<SubCategoryDTO> response = new ApiResponse<>();
        try {
            SubCategoryDTO updateSubCategory = subCategoryService.updateSubCategory(subCategoryId, subCategoryDTO);
            if (updateSubCategory != null) {
                response.setStatus(200);
                response.setMessage("Successfully updated a SubCategory!");
                response.setData(updateSubCategory);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to update a SubCategory!");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to update a SubCategory!" + ae.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSubCategory/{subCategoryId}")
    public ResponseEntity<ApiResponse<Void>> deleteSubCategory(@PathVariable Long subCategoryId) {
        ApiResponse<Void> response = new ApiResponse<>();
        try {
            subCategoryService.deleteSubCategoryById(subCategoryId);
            if (subCategoryId != null) {
                response.setStatus(200);
                response.setMessage("Successfully deleted a SubCategory!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setStatus(500);
                response.setMessage("Failed to delete a SubCategory!");
                response.setData(null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (ApplicationBusinessException ae) {
            response.setStatus(500);
            response.setMessage("Unable to delete a SubCategory!" + ae.getMessage());
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
