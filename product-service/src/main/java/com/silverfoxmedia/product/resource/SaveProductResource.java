package com.silverfoxmedia.product.resource;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveProductResource {

    @NotNull
    private String name;

    @NotNull
    @Lob
    private String description;

    private Double price;

    @Column(name = "category_id")
    private Long categoryId;

    public String getName() {
        return name;
    }

    public SaveProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveProductResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public SaveProductResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public SaveProductResource setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
