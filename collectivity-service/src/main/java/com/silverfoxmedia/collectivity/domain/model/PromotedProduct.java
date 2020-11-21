package com.silverfoxmedia.collectivity.domain.model;

public class PromotedProduct {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String state;

    public Long getId() {
        return id;
    }

    public PromotedProduct setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PromotedProduct setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PromotedProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public PromotedProduct setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getState() {
        return state;
    }

    public PromotedProduct setState(String state) {
        this.state = state;
        return this;
    }
}
