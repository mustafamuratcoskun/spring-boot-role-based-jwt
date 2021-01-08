package com.yazilimbilimi.springbootjwtimplementation.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
// Test Controller Layer with roles based authorization
public class ProductController {
    // Every User can access
    @GetMapping()
    public String getAllProducts(){
        return "Get All Products";
    }

}
