package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PromotedProductService {

    Page<PromotedProduct> getAllPromotedProducts(Pageable pageable);
    PromotedProduct getPromotedProductById(Long promotedProductId);
    PromotedProduct createPromotedProduct(PromotedProduct promotedProduct);
    PromotedProduct updatePromotedProduct(Long promotedProductId, PromotedProduct promotedProductRequest);
    ResponseEntity<?> deletePromotedProduct(Long promotedProductId);
}
