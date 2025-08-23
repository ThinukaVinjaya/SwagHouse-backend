package com.thinuka.SwagHouse_backend.services;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import com.thinuka.SwagHouse_backend.entities.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(ProductDto product);
    public List<ProductDto> getAllProducts(Long categoryId, Long typeId);

    ProductDto getProductBySlug(String slug);

    ProductDto getProductById(Long id);

    Product updateProduct(ProductDto productDto, Long id);

    Product fetchProductById(Long uuid) throws Exception;


}
