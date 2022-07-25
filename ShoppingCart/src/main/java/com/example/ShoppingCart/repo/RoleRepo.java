package com.example.ShoppingCart.repo;


import com.example.ShoppingCart.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
}
