package com.example.wanderingyak.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "carts")
public class Cart {

    @Id
    private String _id;
    private String userId;
    private List<CartProduct> products;

    public String getId() {
        return this._id;
    }

    public String getUserId() {
        return this.userId;
    }

    public List<CartProduct> getCartProducts() {
        return this.products;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }
}

class CartProduct {
    private String productId;
    private int quantity;
    private String name;
    private int price;

    public String getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
