package io.a10.jakartaomni.contoller;

import io.a10.jakartaomni.entity.Category;
import io.a10.jakartaomni.entity.Products;
import io.a10.jakartaomni.entity.Products_;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Stateless
public class ProductsController {
    Products products;
    Category category;
    @PersistenceContext
    EntityManager entityManager;

    public List<Products> allProducts() {
        return entityManager.createNamedQuery("Products.findAll", Products.class).getResultList();
    }

    public List<Products> findLike(String prefix) {
        return entityManager.createNamedQuery("Products.startingWith", Products.class).setParameter("likeExpression", prefix + "%").getResultList();
    }

    public void addProduct(Products products, Category category) {
        entityManager.merge(products);
    }

    public void deleteProduct(Long product_id) {
        entityManager.remove(findById(product_id));
    }

    public Products findById(Long product_id) {
        return entityManager.createNamedQuery("Products.find", Products.class).setParameter("productId", product_id).getSingleResult();
    }

    public void updateProduct(Products product) {
        entityManager.merge(product);
    }


    public List<Products> sortByCategory(Long category_id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Products> criteriaQuery = criteriaBuilder.createQuery(Products.class);
        Root<Products> products = criteriaQuery.from(Products.class);
        products.fetch(Products_.category);
        criteriaQuery.select(products);
        Predicate predicate = criteriaBuilder.equal(products.get(Products_.category), category_id);
        criteriaQuery.where(predicate);
        TypedQuery<Products> query = entityManager.createQuery(criteriaQuery);
        List<Products> productsList = query.getResultList();
        return productsList;
    }
}