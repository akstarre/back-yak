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

    public List<CartProduct> getCartItems() {
        return this.products;
    }
}

class CartProduct {
    private String productId;
    private int quantity;

    public String getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
