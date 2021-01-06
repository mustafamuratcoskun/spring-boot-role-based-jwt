package com.yazilimbilimi.springbootjwtimplementation.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDto {

    private String username;
    private String password;
}
