package io.a10.jakartaomni.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
        @NamedQuery(name = "Category.findById", query = "SELECT c FROM Category c WHERE c.category_id=:categoryId"),
        @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name=:name")
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long category_id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)  //, cascade = CascadeType.ALL, fetch = FetchType.EAGER, fetch = FetchType.LAZY, )
    private List<Products> products = new ArrayList<>();

    @Override
    public String toString() {
        return name;
    }

    public Category(Long category_id, String name, List<Products> products) {
        this.category_id = category_id;
        this.name = name;
        this.products = products;
    }

    public Category() {
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}

