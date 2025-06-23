package com.gosuto.productservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gosuto.productservice.dto.ProductRequest;
import com.gosuto.productservice.dto.ProductResponse;
import com.gosuto.productservice.model.Product;

@Component
public class ProductMapper {

    public ProductResponse toDTO(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public List<ProductResponse> toDTOList(List<Product> products) {
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
