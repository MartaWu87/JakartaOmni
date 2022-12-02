package io.a10.jakartaomni;


import io.a10.jakartaomni.contoller.CategoryController;
import io.a10.jakartaomni.contoller.ProductsController;
import io.a10.jakartaomni.entity.Category;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.omnifaces.cdi.ViewScoped;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CategoryBean implements Serializable {

    @Inject
    CategoryController categoryController;

    @Inject
    ProductsController productsController;

    private Long category_id;

    private String name;
    private List<Category> categoryList;


    @PostConstruct
    public void init()  {
        categoryList = categoryController.allCategory();
    }

    public List<Category> allCategory() {
        categoryList = categoryController.allCategory();
        return categoryList;
    }

    public void findByName(String name) {
        categoryController.findByName(name);
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
