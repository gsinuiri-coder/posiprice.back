package com.silverfoxmedia.product.resource;

public class ProductCatalogResource extends ProductResource {

    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public ProductCatalogResource setActive(boolean active) {
        isActive = active;
        return this;
    }
}
