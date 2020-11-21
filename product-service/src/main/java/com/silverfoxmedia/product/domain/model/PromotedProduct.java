package com.silverfoxmedia.product.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "promotedProducts")
public class PromotedProduct extends Product{

    private String state;

    public String getState() {
        return state;
    }

    public PromotedProduct setState(String state) {
        this.state = state;
        return this;
    }
}
