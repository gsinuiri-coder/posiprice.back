package com.silverfoxmedia.product.service;

import com.silverfoxmedia.product.entity.Comment;
import com.silverfoxmedia.product.entity.Product;

import java.util.List;

public interface CommentService {

    public List<Comment> listAllComment();
    public Comment getComment(Long id);

    public Comment createComment(Comment product);
    public Comment updateComment(Comment product);
    public  Comment deleteComment(Long id);
    public List<Comment> findByProduct(Product product);
    
}
