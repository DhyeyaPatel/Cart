package com.example.ShoppingCart.models;

import javax.persistence.*;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cpId;

    @ManyToOne(targetEntity = Cart.class)
    @JoinColumn(name = "cart",referencedColumnName = "cpId")
    private Cart cart;

    private Product product;

    private Integer quantity = 1;

    public CartProduct() {
        super();
    }

    public CartProduct(Cart cart, Product product, Integer quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
