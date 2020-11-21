package com.silverfoxmedia.collectivity.resource;

import com.silverfoxmedia.collectivity.domain.model.AuditModel;
import com.silverfoxmedia.collectivity.domain.model.ProductCatalog;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VoteProductCatalogResource extends AuditModel {

    private Long id;
    private Long minimumVotes;
    private ProductCatalog productCatalog;


    public Long getId() {
        return id;
    }

    public VoteProductCatalogResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getMinimumVotes() {
        return minimumVotes;
    }

    public VoteProductCatalogResource setMinimumVotes(Long minimumVotes) {
        this.minimumVotes = minimumVotes;
        return this;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public VoteProductCatalogResource setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        return this;
    }
}
