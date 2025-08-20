package com.thinuka.SwagHouse_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private boolean isNewArrival;
    private Long categoryId;
    private Long categoryTypeId;
    private List<ProductVariantDto> variants;
    private List<ProductResourceDto> productResources;


}
