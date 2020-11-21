package com.silverfoxmedia.product.resource;

public class SavePromotedProductResource extends SaveProductResource{

    private String state;

    public String getState() {
        return state;
    }

    public SavePromotedProductResource setState(String state) {
        this.state = state;
        return this;
    }
}
