package com.gosuto.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import static com.gosuto.productservice.constant.ErrorMessage.PRODUCT_NOT_FOUND_WITH_ID;
import com.gosuto.productservice.dto.ProductRequest;
import com.gosuto.productservice.dto.ProductResponse;
import com.gosuto.productservice.exceptions.RessourceNotFoundException;
import com.gosuto.productservice.mapper.ProductMapper;
import com.gosuto.productservice.model.Product;
import com.gosuto.productservice.repositories.ProductRepository;
import com.gosuto.productservice.service.interfaces.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        return productMapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException(PRODUCT_NOT_FOUND_WITH_ID + id));
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.toDTOList(productRepository.findAll());
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
