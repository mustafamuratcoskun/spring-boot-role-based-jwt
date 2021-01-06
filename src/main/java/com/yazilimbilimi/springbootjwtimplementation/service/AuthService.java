package com.yazilimbilimi.springbootjwtimplementation.service;

import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserLoginDto;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;

import java.util.List;

public interface AuthService {
    void register(UserRegisterDto userRegisterDto);

    void login(UserLoginDto userLoginDto);
}
