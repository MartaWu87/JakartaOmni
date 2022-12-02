package io.a10.jakartaomni.contoller;

import io.a10.jakartaomni.entity.Category;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CategoryController {

    @PersistenceContext
    EntityManager entityManager;

    public List<Category> allCategory() {
        return entityManager.createNamedQuery("Category.findAll", Category.class).getResultList();
    }
    public Category findByName(String name) {
        return entityManager.createNamedQuery("Category.findByName", Category.class).setParameter("name", name).getSingleResult();
    }

    public Category findById(Long categoryId) {
        return entityManager.createNamedQuery("Category.findById", Category.class).setParameter("categoryId", categoryId).getSingleResult();
    }
}
