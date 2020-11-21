package com.silverfoxmedia.product.resource;

public class PromotedProductResource extends ProductResource{

    private String state;

    public String getState() {
        return state;
    }

    public PromotedProductResource setState(String state) {
        this.state = state;
        return this;
    }
}
