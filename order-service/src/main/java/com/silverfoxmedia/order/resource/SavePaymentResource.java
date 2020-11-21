package com.silverfoxmedia.order.resource;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SavePaymentResource {

    @Lob
    private String description;

    @NotNull
    private Double total;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_catalog_id")
    private Long productCatalogId;


    public String getDescription() {
        return description;
    }

    public SavePaymentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public SavePaymentResource setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public SavePaymentResource setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductCatalogId() {
        return productCatalogId;
    }

    public SavePaymentResource setProductCatalogId(Long productCatalogId) {
        this.productCatalogId = productCatalogId;
        return this;
    }
}
