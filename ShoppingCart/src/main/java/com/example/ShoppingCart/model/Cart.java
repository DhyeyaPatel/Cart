package com.example.ShoppingCart.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Double totalAmount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private Users users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId" , referencedColumnName = "cartId")
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
