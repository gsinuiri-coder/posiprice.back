package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PromotedProductService {

    Page<PromotedProduct> getAllPromotedProductsByCategoryId(Long categoryId, Pageable pageable);
    PromotedProduct getPromotedProductByIdAndCategoryId(Long categoryId, Long productCatalogId);
    PromotedProduct createPromotedProduct(Long categoryId, PromotedProduct productCatalog);
    PromotedProduct updatePromotedProduct(Long categoryId, Long productCatalogId, PromotedProduct productCatalogDetails);
    ResponseEntity<?> deletePromotedProduct(Long categoryId, Long productCatalogId);
}
