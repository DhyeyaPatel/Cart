package com.example.ShoppingCart.models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;
    private Double price;

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "seller", referencedColumnName = "productId")
    private Users seller;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category", referencedColumnName = "productId")
    private Category category;

    public Product() {
        super();
    }

    public Product(Integer productId, String productName, Double price, Users seller, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
