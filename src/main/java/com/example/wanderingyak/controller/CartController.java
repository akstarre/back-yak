package com.example.wanderingyak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wanderingyak.model.Cart;
import com.example.wanderingyak.service.CartService;

@RestController

@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createOrUpdateCart(@RequestBody Cart cart) {
        System.out.println(cart);
        Cart savedCart = cartService.saveCart(cart);

        return ResponseEntity.ok(savedCart);
    }
}
