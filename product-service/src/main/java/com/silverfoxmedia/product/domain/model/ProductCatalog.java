package com.silverfoxmedia.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productCatalogs")
public class ProductCatalog extends Product{

    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public ProductCatalog setActive(boolean active) {
        isActive = active;
        return this;
    }
}
