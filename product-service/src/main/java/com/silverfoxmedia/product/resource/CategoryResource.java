package com.silverfoxmedia.product.resource;

import com.silverfoxmedia.product.domain.model.AuditModel;

public class CategoryResource extends AuditModel {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public CategoryResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryResource setName(String name) {
        this.name = name;
        return this;
    }
}
