//package com.silverfoxmedia.collectivity.client;
//
//import com.silverfoxmedia.collectivity.domain.model.PromotedProduct;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PromotedProductHystrixFallbackFactory implements PromotedProductClient {
//
//    @Override
//    public ResponseEntity<PromotedProduct> getPromotedProduct(long id) {
//
//        PromotedProduct promotedProduct = new PromotedProduct();
//        promotedProduct.setName("none");
//        promotedProduct.setDescription("none");
//        promotedProduct.setPrice(null);
//        promotedProduct.setState("none");
//
//        return ResponseEntity.ok(promotedProduct);
//    }
//}
