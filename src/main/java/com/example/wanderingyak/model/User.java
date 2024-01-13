package com.example.wanderingyak.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "users")
public class User {
    @Id
    private String _id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String phoneNumber;
    private String address;
    private boolean isActive;
    private String role;

    public String getId() {
        return this._id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFullName() {
        return this.fullname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public String getRole() {
        return this.role;
    }

    public void setID(String _id) {
        this._id = _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
