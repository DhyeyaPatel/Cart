package com.example.ShoppingCart.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String username;
    private String password;

    @ManyToMany(targetEntity = Role.class)
    @JoinColumn(name = "roles", referencedColumnName = "userId")
    private Set<Object> roles;


    public Users() {
        super();
    }

    public Users(Integer userId, String username, String password, Set<Object> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Object> getRoles() {
        return roles;
    }

    public void setRoles(Set<Object> roles) {
        this.roles = roles;
    }
}
