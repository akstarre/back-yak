package com.example.wanderingyak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.wanderingyak.model.User;
import com.example.wanderingyak.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        newUser.setIsActive(true);

        return userRepository.save(newUser);
    }

    public boolean authenticateUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return true;
        }
        return false;
    }

    public String getUserIdByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get().getId();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public User getUserShippingByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
