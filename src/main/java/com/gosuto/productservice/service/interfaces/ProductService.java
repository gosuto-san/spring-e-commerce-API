package com.gosuto.productservice.service.interfaces;

import java.util.List;

import com.gosuto.productservice.dto.ProductRequest;
import com.gosuto.productservice.dto.ProductResponse;

public interface ProductService {
  ProductResponse createProduct(ProductRequest request);
  ProductResponse getProductById(Long id);
  List<ProductResponse> getAllProducts();
  boolean deleteProduct(Long id);
}
