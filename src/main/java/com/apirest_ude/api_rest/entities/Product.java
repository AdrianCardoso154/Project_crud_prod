package com.apirest_ude.api_rest.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_produto")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String desccription;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String igmUri;

    @ManyToMany
    @JoinTable(name = "tb_prod_cat", joinColumns = @JoinColumn (name = "Prod_id"), inverseJoinColumns =@JoinColumn(name = "cat_id"))
    private List<Category> categories = new ArrayList<>();
    public List<Category> getCategories(){return categories;}


    @ManyToMany
    @JoinTable(name = "tb_prod_order",joinColumns = @JoinColumn(name = "prod_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders = new ArrayList<>();
    public List<Order> getOrders(){return orders;}


    public Product() {
    }

    public Product(String name, String desccription, Double price, String igmUri) {
        this.name = name;
        this.desccription = desccription;
        this.price = price;
        this.igmUri = igmUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product Product = (Product) o;
        return Objects.equals(getId(), Product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIgmUri() {
        return igmUri;
    }

    public void setIgmUri(String igmUri) {
        this.igmUri = igmUri;
    }

}
