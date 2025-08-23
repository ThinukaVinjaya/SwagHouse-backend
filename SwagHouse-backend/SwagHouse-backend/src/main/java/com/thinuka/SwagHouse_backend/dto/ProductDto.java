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
    private Float rating;
    private Long categoryId;
    private String thumbnail;
    private String slug;
    private String categoryName;
    private Long categoryTypeId;
    private String categoryTypeName;
    private List<ProductVariantDto> variants;
    private List<ProductResourceDto> productResources;


}
