package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.entity.Product;
import com.silverfoxmedia.product.entity.Comment;
import com.silverfoxmedia.product.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService ;

    @GetMapping
    public ResponseEntity<List<Comment>> listComment(@RequestParam(name = "productId", required = false) Long productId){
        List<Comment> comments = new ArrayList<>();
        if (null ==  productId){
            comments = commentService.listAllComment();
            if (comments.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }else{
            comments = commentService.findByProduct(Product.builder().id(productId).build());
            if (comments.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        }


        return ResponseEntity.ok(comments);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable("id") Long id) {
        Comment comment =  commentService.getComment(id);
        if (null==comment){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

//    @PostMapping
//    public ResponseEntity<Comment> createComment(@Valid @RequestBody Comment comment, BindingResult result){
//        if (result.hasErrors()){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
//        }
//        Comment commentCreate =  commentService.createComment(comment);
//        return ResponseEntity.status(HttpStatus.CREATED).body(commentCreate);
//    }
}
