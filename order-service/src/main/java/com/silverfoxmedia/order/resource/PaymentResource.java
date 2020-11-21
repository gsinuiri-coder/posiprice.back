package com.silverfoxmedia.order.resource;

import com.silverfoxmedia.order.domain.model.AuditModel;
import com.silverfoxmedia.order.domain.model.ProductCatalog;
import com.silverfoxmedia.order.domain.model.User;

public class PaymentResource extends AuditModel {

    private Long id;
    private String description;
    private Double total;
    private User user;
    private ProductCatalog productCatalog;


    public Long getId() {
        return id;
    }

    public PaymentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public PaymentResource setTotal(Double total) {
        this.total = total;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PaymentResource setUser(User user) {
        this.user = user;
        return this;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public PaymentResource setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        return this;
    }
}
