package com.example.wanderingyak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wanderingyak.model.Cart;
import com.example.wanderingyak.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> findByUserId(String id) {
        return cartRepository.findByUserId(id);
    }
}
