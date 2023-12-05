package com.example.demojwt.persistence.repository;

import com.example.demojwt.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
