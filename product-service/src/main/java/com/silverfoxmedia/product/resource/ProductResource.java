package com.silverfoxmedia.product.resource;

import com.silverfoxmedia.product.domain.model.AuditModel;
import com.silverfoxmedia.product.domain.model.Category;

public class ProductResource extends AuditModel {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;

    public Long getId() {
        return id;
    }

    public ProductResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductResource setCategory(Category category) {
        this.category = category;
        return this;
    }
}
