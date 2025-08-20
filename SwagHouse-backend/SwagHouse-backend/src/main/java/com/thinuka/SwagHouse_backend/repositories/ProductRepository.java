package com.thinuka.SwagHouse_backend.repositories;

import com.thinuka.SwagHouse_backend.dto.ProductDto;
import com.thinuka.SwagHouse_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
