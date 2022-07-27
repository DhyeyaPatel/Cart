package com.example.ShoppingCart.model;

import javax.persistence.*;

@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cpId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId",referencedColumnName = "cartId")
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product", referencedColumnName = "productId")
    private Product product;

    private Integer quantity = 1;

    public CartProduct() {
        super();
    }

    public CartProduct(Integer cpId, Cart cart, Product product, Integer quantity) {
        this.cpId = cpId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "cpId=" + cpId +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
