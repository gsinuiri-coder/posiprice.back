package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    Page<Comment> getAllCommentsByProductCatalogId(Long productCatalogId, Pageable pageable);
    Comment getCommentByIdAndProductCatalogId(Long productCatalogId, Long commentId);
    Comment createComment(Long productCatalogId, Comment comment);
    Comment updateComment(Long productCatalogId, Long commentId, Comment commentDetails);
    ResponseEntity<?> deleteComment(Long productCatalogId, Long commentId);
}
