package com.silverfoxmedia.product.resource;

public class SaveProductCatalogResource extends SaveProductResource{
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public SaveProductCatalogResource setActive(boolean active) {
        isActive = active;
        return this;
    }
}
