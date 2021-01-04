package com.yazilimbilimi.springbootjwtimplementation.repository;

import com.yazilimbilimi.springbootjwtimplementation.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
