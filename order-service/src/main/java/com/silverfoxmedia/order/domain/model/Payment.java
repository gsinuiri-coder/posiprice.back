package com.silverfoxmedia.order.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "payments")
public class Payment extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String description;

    @NotNull
    private Double total;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_catalog_id")
    private Long productCatalogId;

    @Transient
    private User user;

    @Transient
    private ProductCatalog productCatalog;


    public Long getId() {
        return id;
    }

    public Payment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Payment setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public Payment setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Payment setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getProductCatalogId() {
        return productCatalogId;
    }

    public Payment setProductCatalogId(Long productCatalogId) {
        this.productCatalogId = productCatalogId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Payment setUser(User user) {
        this.user = user;
        return this;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public Payment setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        return this;
    }
}
