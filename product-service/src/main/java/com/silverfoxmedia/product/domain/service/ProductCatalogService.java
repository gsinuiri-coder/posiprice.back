package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductCatalogService {
    Page<ProductCatalog> getAllProductCatalogs(Pageable pageable);
    ProductCatalog getProductCatalogById(Long productCatalogId);
    ProductCatalog createProductCatalog(ProductCatalog productCatalog);
    ProductCatalog updateProductCatalog(Long productCatalogId, ProductCatalog productCatalogRequest);
    ResponseEntity<?> deleteProductCatalog(Long productCatalogId);
}
