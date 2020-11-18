package com.silverfoxmedia.product.resource;

import javax.validation.constraints.NotNull;

public class SaveCategoryResource {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public SaveCategoryResource setName(String name) {
        this.name = name;
        return this;
    }
}
