package com.silverfoxmedia.product.resource;

public class SavePromotedProductResource extends SaveProductResource{

    private String status;

    public String getStatus() {
        return status;
    }

    public SavePromotedProductResource setStatus(String status) {
        this.status = status;
        return this;
    }
}
