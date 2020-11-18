package com.silverfoxmedia.product.domain.repository;

import com.silverfoxmedia.product.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByProductCatalogId(Long productCatalogId, Pageable pageable);
    Optional<Comment> findByIdAndProductCatalogId(Long id, Long productCatalogId);
}
