package com.silverfoxmedia.product.resource;

import com.silverfoxmedia.product.domain.model.Product;

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
