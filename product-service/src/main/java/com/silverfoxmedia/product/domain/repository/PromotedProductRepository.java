package com.silverfoxmedia.product.domain.repository;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromotedProductRepository extends JpaRepository<PromotedProduct, Long> {

        Page<PromotedProduct> findByCategoryId(Long categoryId, Pageable pageable);
        Optional<PromotedProduct> findByIdAndCategoryId(Long id, Long categoryId);
}
