package com.cargo.service.impl;

import com.cargo.model.Role;
import com.cargo.model.User;
import com.cargo.repository.UserRepository;
import com.cargo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User create(String username, String password, Role role) {
        String encryptedPassword =passwordEncoder.encode(password);
        User user=new User(username,encryptedPassword,role);
        return this.userRepository.save(user);
    }
}