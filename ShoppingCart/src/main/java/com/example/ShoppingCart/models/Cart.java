package com.example.ShoppingCart.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    private Double totalAmount;

    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "user", referencedColumnName = "cartId")
    private Users users;

    @OneToMany(targetEntity = CartProduct.class)
    @JoinColumn(name = "cp", referencedColumnName = "cartId")
    private List<CartProduct> cartProducts;

    public Cart() {
        super();
    }

    public Cart(Integer cartId, Double totalAmount, Users users, List<CartProduct> cartProducts) {
        this.cartId = cartId;
        this.totalAmount = totalAmount;
        this.users = users;
        this.cartProducts = cartProducts;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
