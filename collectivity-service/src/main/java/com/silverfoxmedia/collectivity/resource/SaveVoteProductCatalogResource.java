package com.silverfoxmedia.collectivity.resource;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SaveVoteProductCatalogResource {

    private Long minimumVotes;

    @Column(name = "product_catalog_id")
    private Long productCatalogId;

    public Long getMinimumVotes() {
        return minimumVotes;
    }

    public SaveVoteProductCatalogResource setMinimumVotes(Long minimumVotes) {
        this.minimumVotes = minimumVotes;
        return this;
    }

    public Long getProductCatalogId() {
        return productCatalogId;
    }

    public SaveVoteProductCatalogResource setProductCatalogId(Long productCatalogId) {
        this.productCatalogId = productCatalogId;
        return this;
    }
}
