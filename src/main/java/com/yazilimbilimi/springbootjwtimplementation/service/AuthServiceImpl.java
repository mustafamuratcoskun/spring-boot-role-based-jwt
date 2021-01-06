package com.yazilimbilimi.springbootjwtimplementation.service;

import com.yazilimbilimi.springbootjwtimplementation.domain.Role;
import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.domain.dto.UserRegisterDto;
import com.yazilimbilimi.springbootjwtimplementation.repository.RoleRepository;
import com.yazilimbilimi.springbootjwtimplementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Set<Role> getRoles(String [] roles){
        Set<Role> userRoles = new HashSet<>();
        for(String role : roles) {
            userRoles.add(roleRepository.findByName(role));
        }
        return userRoles;
    }

}
