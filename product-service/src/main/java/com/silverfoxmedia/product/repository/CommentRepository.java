package com.silverfoxmedia.product.repository;

import com.silverfoxmedia.product.entity.Comment;
import com.silverfoxmedia.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findByProduct(Product product);
}
