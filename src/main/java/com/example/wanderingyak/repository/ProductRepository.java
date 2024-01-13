package com.example.wanderingyak.repository;

import com.example.wanderingyak.model.Product;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, ObjectId> {
    List<Product> findByCategory(String category);

    Optional<Product> findBy_id(String _id);
}
