package com.yazilimbilimi.springbootjwtimplementation.controller;

import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;
import com.yazilimbilimi.springbootjwtimplementation.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegisterDto userRegisterDto) {
        userService.add(userRegisterDto);
        return "Successful";
    }



}
