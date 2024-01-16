package com.example.wanderingyak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable String userId) {
        try {
            List<Cart> orderHistory = cartService.findByUserId(userId);
            return ResponseEntity.ok(orderHistory);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
}
