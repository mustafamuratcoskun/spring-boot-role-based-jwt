package com.yazilimbilimi.springbootjwtimplementation.util.Security.jwt;

import com.yazilimbilimi.springbootjwtimplementation.domain.Role;
import com.yazilimbilimi.springbootjwtimplementation.util.Security.AccessToken;
import com.yazilimbilimi.springbootjwtimplementation.util.Security.SecretKey;

import java.util.Set;

public interface IJwtTokenHelper {
    String generateJwtToken(SecretKey secretKey, String username, Set<Role> roles);
    boolean validateJwtToken(SecretKey secretKey,AccessToken accessToken);
    String getUsernameFromJwtToken(SecretKey secretKey,AccessToken accessToken);
}
