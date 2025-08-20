package com.thinuka.SwagHouse_backend.services;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import com.thinuka.SwagHouse_backend.dto.ProductVariantDto;
import com.thinuka.SwagHouse_backend.entities.Product;
import com.thinuka.SwagHouse_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImple implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return List.of();
    }

    private Product createProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setNewArrival(productDto.isNewArrival());
        product.setPrice(productDto.getPrice());
        return product;
    }
}
