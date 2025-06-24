package com.gosuto.productservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosuto.productservice.model.Category;
import com.gosuto.productservice.model.Product;
import com.gosuto.productservice.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findByProduct(Product product);

    List<ProductCategory> findByCategory(Category category);

    Optional<ProductCategory> findByProductAndCategory(Product product, Category category);

    boolean existsByProductAndCategory(Product product, Category category);

    void deleteByProductAndCategory(Product product, Category category);
}
