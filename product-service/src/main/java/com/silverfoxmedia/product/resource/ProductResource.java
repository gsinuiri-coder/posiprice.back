package com.silverfoxmedia.product.resource;

import com.silverfoxmedia.product.domain.model.AuditModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class ProductResource extends AuditModel {

    private Long id;
    private String name;
    private String description;
    private Double price;

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
}
