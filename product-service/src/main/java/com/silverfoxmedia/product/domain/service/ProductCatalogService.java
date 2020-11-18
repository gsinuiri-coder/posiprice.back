package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductCatalogService {
    Page<ProductCatalog> getAllProductCatalogsByCategoryId(Long categoryId, Pageable pageable);
    ProductCatalog getProductCatalogByIdAndCategoryId(Long categoryId, Long productCatalogId);
    ProductCatalog createProductCatalog(Long categoryId, ProductCatalog productCatalog);
    ProductCatalog updateProductCatalog(Long categoryId, Long productCatalogId, ProductCatalog productCatalogDetails);
    ResponseEntity<?> deleteProductCatalog(Long categoryId, Long productCatalogId);
}
