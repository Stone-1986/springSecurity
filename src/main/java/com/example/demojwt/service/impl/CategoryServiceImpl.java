package com.example.demojwt.service.impl;

import com.example.demojwt.dto.SaveCategory;
import com.example.demojwt.exception.ObjectNotFoundException;
import com.example.demojwt.persistence.entity.Category;
import com.example.demojwt.persistence.enums.CategoryStatus;
import com.example.demojwt.persistence.repository.CategoryRepository;
import com.example.demojwt.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOne(SaveCategory saveCategory) {
        Category category = Category.builder()
                .name(saveCategory.getName())
                .status(CategoryStatus.ENABLED)
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ObjectNotFoundException("categoria no encontrada con id " + categoryId));
        category.setName(saveCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category disableOneById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ObjectNotFoundException("categoria no encontrada con id " + categoryId));
        category.setStatus(CategoryStatus.DISABLED);
        return categoryRepository.save(category);
    }
}
