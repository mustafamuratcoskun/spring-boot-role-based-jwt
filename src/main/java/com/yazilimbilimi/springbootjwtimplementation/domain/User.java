package com.yazilimbilimi.springbootjwtimplementation.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;



@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor()
@Entity
@Builder
@Table(name = "users")
public class User extends BaseEntity {

    @Size(min = 6,message = "Username length must be minimum 6")
    @Column(name = "username",unique = true)
    private String username;

    @Email(message = "Email Should Be Valid")
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Size(min = 8,message = "Password length must be minimum 8")
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",referencedColumnName = "id"
            )
    )
    private Set<Role> roles  = new HashSet<>();



}
