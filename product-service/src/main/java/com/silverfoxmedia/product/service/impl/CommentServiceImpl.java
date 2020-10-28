package com.silverfoxmedia.product.service.impl;

import com.silverfoxmedia.product.entity.Category;
import com.silverfoxmedia.product.entity.Comment;
import com.silverfoxmedia.product.entity.Product;
import com.silverfoxmedia.product.repository.CommentRepository;
import com.silverfoxmedia.product.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    
    private final CommentRepository CommentRepository;

    @Override
    public List<Comment> listAllComment() {
        return CommentRepository.findAll();
    }

    @Override
    public Comment getComment(Long id) {
        return CommentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(Comment Comment) {
        Comment.setCreateAt(new Date());

        return CommentRepository.save(Comment);
    }

    @Override
    public Comment updateComment(Comment Comment) {
        Comment CommentDB = getComment(Comment.getId());
        if (null == CommentDB){
            return null;
        }
        CommentDB.setText(Comment.getText());
//        CommentDB.setDescription(Comment.getDescription());
//        CommentDB.setCategory(Comment.getCategory());
//        CommentDB.setPrice(Comment.getPrice());
        return CommentRepository.save(CommentDB);
    }

    @Override
    public Comment deleteComment(Long id) {
        Comment CommentDB = getComment(id);
        if (null == CommentDB){
            return null;
        }
        return CommentRepository.save(CommentDB);
    }

    @Override
    public List<Comment> findByProduct(Product product) {
        return CommentRepository.findByProduct(product);
    }
}
