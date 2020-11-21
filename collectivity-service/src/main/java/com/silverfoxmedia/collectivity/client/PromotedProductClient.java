//package com.silverfoxmedia.collectivity.client;
//
//import com.silverfoxmedia.collectivity.domain.model.PromotedProduct;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "product-service", fallback = ProductCatalogHystrixFallbackFactory.class)
////@RequestMapping("/api")
//public interface PromotedProductClient {
//
//    @GetMapping("/api/promotedProducts/{id}")
//    public ResponseEntity<PromotedProduct> getPromotedProduct(@PathVariable(value = "id") long id);
//}
