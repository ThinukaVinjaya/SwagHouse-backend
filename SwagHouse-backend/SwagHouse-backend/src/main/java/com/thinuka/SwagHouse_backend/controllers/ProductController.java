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
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        // Convert DTO -> Entity
        Product product = mapToEntity(productDto);

        // Save using service
        Product savedProduct = productService.addProduct(product);

        // Convert Entity -> DTO
        ProductDto savedDto = mapToDto(savedProduct);

        // Return with HTTP 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }


    private Product mapToEntity(ProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .brand(dto.getBrand())
                .isNewArrival(dto.isNewArrival())
                .build();
    }

    private ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .brand(product.getBrand())
                .isNewArrival(product.isNewArrival())
                .build();
    }

}
