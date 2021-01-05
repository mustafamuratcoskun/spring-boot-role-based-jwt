package com.yazilimbilimi.springbootjwtimplementation.service;

import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;
import com.yazilimbilimi.springbootjwtimplementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void add(UserRegisterDto userRegisterDto) {
        User user = User
                .builder()
                .email(userRegisterDto.getEmail())
                .username(userRegisterDto.getUsername())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .build();
        userRepository.save(user);
    }
}
