package com.thinuka.SwagHouse_backend.controllers;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import com.thinuka.SwagHouse_backend.dto.ProductResourceDto;
import com.thinuka.SwagHouse_backend.entities.Product;
import com.thinuka.SwagHouse_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();

        // Convert List<Product> -> List<ProductDto> using builder
        List<ProductDto> dtoList = productList.stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .brand(product.getBrand())
                        .isNewArrival(product.isNewArrival())
                        .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                        .categoryTypeId(product.getCategoryType() != null ? product.getCategoryType().getId() : null)
                        .build())
                .toList();

        return ResponseEntity.ok(dtoList);
    }



    // create Product
    @PostMapping
    public ResponseEntity<Product> crateProduct(@RequestBody ProductDto productDto){
        Product product1 = productService.addProduct(productDto);
        return null;
    }
}
