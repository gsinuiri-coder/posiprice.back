package com.silverfoxmedia.product.service;


import com.silverfoxmedia.product.domain.model.Comment;
import com.silverfoxmedia.product.domain.repository.CommentRepository;
import com.silverfoxmedia.product.domain.repository.ProductCatalogRepository;
import com.silverfoxmedia.product.domain.service.CommentService;
import com.silverfoxmedia.product.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Override
    public Page<Comment> getAllCommentsByProductCatalogId(Long productCatalogId, Pageable pageable) {
        return commentRepository.findByProductCatalogId(productCatalogId, pageable);
    }

    @Override
    public Comment getCommentByIdAndProductCatalogId(Long productCatalogId, Long commentId) {
        return commentRepository.findByIdAndProductCatalogId(commentId, productCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Comment not found with Id " + commentId +
                                " and ProductCatalogId " + productCatalogId));
    }

    @Override
    public Comment createComment(Long productCatalogId, Comment comment) {
        return productCatalogRepository.findById(productCatalogId).map(productCatalog -> {
            comment.setProductCatalog(productCatalog);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "ProductCatalog", "Id", productCatalogId));
    }

    @Override
    public Comment updateComment(Long productCatalogId, Long commentId, Comment commentDetails) {
        if(!productCatalogRepository.existsById(productCatalogId))
            throw new ResourceNotFoundException("ProductCatalog", "Id", productCatalogId);

        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentDetails.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
    }

    @Override
    public ResponseEntity<?> deleteComment(Long productCatalogId, Long commentId) {
        return commentRepository.findByIdAndProductCatalogId(commentId, productCatalogId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Comment not found with Id " + commentId + " and ProductCatalogId " + productCatalogId));
    }
}
