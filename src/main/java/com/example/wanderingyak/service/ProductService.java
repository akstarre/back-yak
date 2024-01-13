package com.example.wanderingyak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wanderingyak.model.Product;
import com.example.wanderingyak.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public List<Product> productsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Optional<Product> productById(String id) {
        return productRepository.findBy_id(id);
    }

}
