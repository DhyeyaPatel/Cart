package com.example.ShoppingCart.Repo;

import com.example.ShoppingCart.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepo extends JpaRepository<CartProduct, Integer> {
}
