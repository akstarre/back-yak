package com.example.wanderingyak.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wanderingyak.model.Cart;

public interface CartRepository extends MongoRepository<Cart, ObjectId> {

}
