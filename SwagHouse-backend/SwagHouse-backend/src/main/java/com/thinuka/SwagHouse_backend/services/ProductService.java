package com.thinuka.SwagHouse_backend.services;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import com.thinuka.SwagHouse_backend.entities.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public List<Product> getAllProducts();


}
