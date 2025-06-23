package com.gosuto.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gosuto.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
