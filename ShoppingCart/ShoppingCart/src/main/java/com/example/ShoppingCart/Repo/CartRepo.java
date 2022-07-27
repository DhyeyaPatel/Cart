package com.example.ShoppingCart.Repo;

import com.example.ShoppingCart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
}
