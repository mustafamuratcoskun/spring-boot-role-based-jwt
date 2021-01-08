package com.yazilimbilimi.springbootjwtimplementation.util.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecretKey {
    private String secretKey;
    private long expirationInMiliseconds;
}
