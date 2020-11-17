package com.silverfoxmedia.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "promotedProducts")
public class PromotedProduct extends Product{

    private String status;

    public String getStatus() {
        return status;
    }

    public PromotedProduct setStatus(String status) {
        this.status = status;
        return this;
    }
}
