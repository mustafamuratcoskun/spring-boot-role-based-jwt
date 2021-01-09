package com.yazilimbilimi.springbootjwtimplementation.controller;


import com.yazilimbilimi.springbootjwtimplementation.util.Constants.ApiMessages;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
// Test Controller Layer with roles based authorization
public class ProductController {

    // Only Admin can access
    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addNewProduct(){
        return "ADD NEW PRODUCT " + "| " + ApiMessages.ONLY_ADMIN_ACCESS;
    }
    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String getAllProducts(){
        return "GET ALL PRODUCTS " + "| " +  ApiMessages.USER_ADMIN_ACCESS;
    }


}
