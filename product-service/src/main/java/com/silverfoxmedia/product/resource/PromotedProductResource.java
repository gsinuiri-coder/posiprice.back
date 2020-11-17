package com.silverfoxmedia.product.resource;

public class PromotedProductResource extends ProductResource{

    private String status;

    public String getStatus() {
        return status;
    }

    public PromotedProductResource setStatus(String status) {
        this.status = status;
        return this;
    }
}
