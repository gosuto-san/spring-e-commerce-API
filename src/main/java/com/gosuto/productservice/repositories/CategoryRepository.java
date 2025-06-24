package com.gosuto.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosuto.productservice.model.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long> {

}
