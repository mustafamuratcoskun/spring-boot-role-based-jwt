package com.yazilimbilimi.springbootjwtimplementation.repository;

import com.yazilimbilimi.springbootjwtimplementation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
