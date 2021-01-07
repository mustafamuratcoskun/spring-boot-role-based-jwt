package com.yazilimbilimi.springbootjwtimplementation.controller;

import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserLoginDto;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;
import com.yazilimbilimi.springbootjwtimplementation.service.AuthService;
import com.yazilimbilimi.springbootjwtimplementation.util.Constants.ApiMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDto userRegisterDto) {

        authService.register(userRegisterDto);
        return ResponseEntity.ok(ApiMessages.REGISTRATION_SUCCESSFUL);

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        authService.login(userLoginDto);
        return ResponseEntity.ok(ApiMessages.LOGIN_SUCCESSFUL);
    }




}
