package com.yazilimbilimi.springbootjwtimplementation.RepositoryTests;

import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import com.yazilimbilimi.springbootjwtimplementation.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserRepository_whenAutowired_ThenNotNull(){

        Assertions.assertNotNull(userRepository, "User Repository is Null");

    }
    @Test
    public void givenUser_ThenAdd(){
        User user = new User();
        user.setEmail("mustafamuratcoskun@gmail.com");
        user.setUsername("mustafamuratcoskun");

        userRepository.save(user);
    }
    @Test
    public void testAllUsers(){
        List<User> users = userRepository.findAll();
        Assertions.assertEquals(1,users.size());
    }
}
