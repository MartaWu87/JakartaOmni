package io.a10.jakartaomni.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p JOIN FETCH p.category"),
        @NamedQuery(name = "Products.startingWith", query = "SELECT p FROM Products p WHERE p.name LIKE :likeExpression"),
        @NamedQuery(name = "Products.find", query = "SELECT p FROM Products p JOIN FETCH p.category WHERE p.product_id=:productId"),
        @NamedQuery(name = "Products.findByCategory", query = "SELECT p FROM Products p JOIN FETCH p.category WHERE p.category in :category_id"),
})
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long product_id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false)
//, insertable = false, updatable = false)
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public Products(Long product_id, String name, Long quantity, Category category) {
        this.product_id = product_id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public Products() {
    }
}

