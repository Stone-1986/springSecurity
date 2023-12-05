package com.example.demojwt.persistence.repository;

import com.example.demojwt.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
