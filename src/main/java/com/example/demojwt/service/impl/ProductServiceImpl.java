package com.example.demojwt.service.impl;

import com.example.demojwt.dto.SaveProduct;
import com.example.demojwt.exception.ObjectNotFoundException;
import com.example.demojwt.persistence.entity.Category;
import com.example.demojwt.persistence.entity.Product;
import com.example.demojwt.persistence.enums.ProductStatus;
import com.example.demojwt.persistence.repository.ProductRepository;
import com.example.demojwt.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOneById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createOne(SaveProduct saveProduct) {
        Category category = Category.builder().id(saveProduct.getCategoryId()).build();
        Product product = Product.builder()
                .name(saveProduct.getName())
                .price(saveProduct.getPrice())
                .status(ProductStatus.ENABLED)
                .category(category)
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product updateOneById(Long productId, SaveProduct saveProduct) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Producto no encontrado con id " + productId));
        Category category = Category.builder().id(saveProduct.getCategoryId()).build();
        product.setName(saveProduct.getName());
        product.setPrice(saveProduct.getPrice());
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product disableOneById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Producto no encontrado con id " + productId));
        product.setStatus(ProductStatus.DISABLED);
        return productRepository.save(product);
    }
}
