package com.silverfoxmedia.product.domain.repository;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotedProductRepository extends JpaRepository<PromotedProduct, Long> {
}
