package com.thinuka.SwagHouse_backend.controllers;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return Collections.EMPTY_LIST;
    }

    // create Product
    @PostMapping
    public ProductDto crateProduct(@RequestBody ProductDto product){
        return null;
    }
}
