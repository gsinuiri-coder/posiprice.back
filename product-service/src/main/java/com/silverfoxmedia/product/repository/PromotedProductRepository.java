package com.silverfoxmedia.product.repository;

import com.silverfoxmedia.product.entity.PromotedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotedProductRepository extends JpaRepository<PromotedProduct, Long> {
}
