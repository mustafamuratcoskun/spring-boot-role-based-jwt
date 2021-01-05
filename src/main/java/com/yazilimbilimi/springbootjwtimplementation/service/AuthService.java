package com.yazilimbilimi.springbootjwtimplementation.service;

import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;

import java.util.List;

public interface AuthService {
    List<User> getAllUsers();
    void add(UserRegisterDto userRegisterDto);
}
