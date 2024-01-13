package com.example.wanderingyak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wanderingyak.config.JwtTokenProvider;
import com.example.wanderingyak.model.AuthResponse;
import com.example.wanderingyak.model.User;
import com.example.wanderingyak.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User regiteredUser = userService.registerUser(user);
            return ResponseEntity.ok(regiteredUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error:" + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());

        if (isAuthenticated) {
            String token = jwtTokenProvider.createToken(user.getUsername(), user.getId());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Error: Authentication failed");
        }
    }

    @GetMapping("/user/findUserByUsername/{username}")
    public ResponseEntity<String> findUserId(@PathVariable String username) {
        try {
            String userId = userService.getUserIdByUsername(username);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @GetMapping("/user/getUserShippingByUsername/{username}")
    public ResponseEntity<User> findUserInfo(@PathVariable String username) {
        try {
            User user = userService.getUserShippingByUsername(username);
            return ResponseEntity.ok(user);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
