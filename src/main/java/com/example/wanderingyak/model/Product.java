package com.example.wanderingyak.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")

public class Product {

    @Id
    private String _id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;
    private List<String> tags;

    public String getId() {
        return this._id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getImage() {
        return this.image;
    }

    public List<String> getTags() {
        return this.tags;
    }

}
