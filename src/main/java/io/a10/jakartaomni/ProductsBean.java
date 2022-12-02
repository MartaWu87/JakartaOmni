package io.a10.jakartaomni;

import io.a10.jakartaomni.contoller.ProductsController;
import io.a10.jakartaomni.entity.Category;
import io.a10.jakartaomni.entity.Products;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
//@ApplicationScoped lub @
public class ProductsBean implements Serializable {

    Logger logger = LoggerFactory.getLogger(ProductsBean.class);
    @EJB
    ProductsController productsController;

    private Long product_id;
    private String name;
    private Long quantity;
    private List<Products> productsList;

    private Category category;
    private String filter;


    @PostConstruct
    public void init() {
        productsList = productsController.allProducts();
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void takeAction() {
        this.productsList = productsController.findLike(filter);
    }

    public String addProduct() {
        Products product = new Products();
        product.setName(name);
        product.setQuantity(quantity);
        product.setCategory(category);
        productsController.addProduct(product, category);
        return "index?faces-redirect=true";
    }

    public String deleteProduct(Long product_id) {
        productsController.deleteProduct(product_id);
        return "remove?faces-redirect=true";
    }

    public String insert() {
        return "insert?faces-redirect=true";
    }

    public String preUpdateProduct(Long product_id) {
        return "update?id=" + product_id + "faces-redirect=true";
    }

    public String back() {
        return "index?faces-redirect=true";
    }

    public void sortByCategory(Long category_id) {
        this.productsList = productsController.sortByCategory(category_id);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ProductsController getProductsController() {
        return productsController;
    }

    public void setProductsController(ProductsController productsController) {
        this.productsController = productsController;
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

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
