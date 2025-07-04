package com.gosuto.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosuto.productservice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
