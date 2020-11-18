package com.silverfoxmedia.product.domain.repository;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
    Page<ProductCatalog> findByCategoryId(Long categoryId, Pageable pageable);
    Optional<ProductCatalog> findByIdAndCategoryId(Long id, Long categoryId);
}
