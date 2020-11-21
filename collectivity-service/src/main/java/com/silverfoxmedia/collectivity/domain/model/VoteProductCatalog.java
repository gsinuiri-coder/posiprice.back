package com.silverfoxmedia.collectivity.domain.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voteProductCatalogs")
public class VoteProductCatalog extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long minimumVotes;

    @Column(name = "product_catalog_id")
    private Long productCatalogId;

    @Transient
    private List<User> users;

    @Transient
    private ProductCatalog productCatalog;

    public Long getId() {
        return id;
    }

    public VoteProductCatalog setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getMinimumVotes() {
        return minimumVotes;
    }

    public VoteProductCatalog setMinimumVotes(Long minimumVotes) {
        this.minimumVotes = minimumVotes;
        return this;
    }

    public Long getProductCatalogId() {
        return productCatalogId;
    }

    public VoteProductCatalog setProductCatalogId(Long productCatalogId) {
        this.productCatalogId = productCatalogId;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public VoteProductCatalog setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public VoteProductCatalog setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
        return this;
    }
}
