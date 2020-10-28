package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.entity.Category;
import com.silverfoxmedia.product.entity.PromotedProduct;
import com.silverfoxmedia.product.service.PromotedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/promotedproducts")
public class PromotedProductController {

    @Autowired
    private PromotedProductService promotedProductService ;

    @GetMapping
    public ResponseEntity<List<PromotedProduct>> listPromotedProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){
        List<PromotedProduct> promotedProducts = new ArrayList<>();
        if (null ==  categoryId){
            promotedProducts = promotedProductService.listAllPromotedProduct();
            if (promotedProducts.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
//        else{
//            promotedProducts = promotedProductService.findByCategory(Category.builder().id(categoryId).build());
//            if (promotedProducts.isEmpty()){
//                return ResponseEntity.notFound().build();
//            }
//        }


        return ResponseEntity.ok(promotedProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PromotedProduct> getPromotedProduct(@PathVariable("id") Long id) {
        PromotedProduct promotedProduct =  promotedProductService.getPromotedProduct(id);
        if (null==promotedProduct){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(promotedProduct);
    }
}
