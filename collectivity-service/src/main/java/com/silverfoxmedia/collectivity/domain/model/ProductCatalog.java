package com.silverfoxmedia.collectivity.domain.model;

public class ProductCatalog {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private boolean isActive;


    public Long getId() {
        return id;
    }

    public ProductCatalog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductCatalog setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCatalog setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductCatalog setPrice(Double price) {
        this.price = price;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public ProductCatalog setActive(boolean active) {
        isActive = active;
        return this;
    }
}
