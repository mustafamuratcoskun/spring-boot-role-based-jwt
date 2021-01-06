package com.yazilimbilimi.springbootjwtimplementation.service;

import com.yazilimbilimi.springbootjwtimplementation.domain.Role;
import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserLoginDto;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;
import com.yazilimbilimi.springbootjwtimplementation.exceptions.security.CustomSecurityException;
import com.yazilimbilimi.springbootjwtimplementation.repository.RoleRepository;
import com.yazilimbilimi.springbootjwtimplementation.repository.UserRepository;
import com.yazilimbilimi.springbootjwtimplementation.util.ApiMessages;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

@Transactional
public class AuthServiceImpl implements AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User user = User
                .builder()
                .email(userRegisterDto.getEmail())
                .username(userRegisterDto.getUsername())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .roles(getRoles(userRegisterDto.getRoles()))
                .build();
        userRepository.save(user);

    }

    @Override
    public void login(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (AuthenticationException exception) {
            throw new CustomSecurityException(ApiMessages.BAD_CREDENTIALS, HttpStatus.BAD_REQUEST);

        }

    }

    private Set<Role> getRoles(String [] roles){
        Set<Role> userRoles = new HashSet<>();
        for(String role : roles) {
            userRoles.add(roleRepository.findByName(role));
        }
        return userRoles;
    }

}
