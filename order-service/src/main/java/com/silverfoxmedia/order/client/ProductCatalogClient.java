package com.silverfoxmedia.order.client;

import com.silverfoxmedia.order.domain.model.ProductCatalog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", fallback = ProductCatalogHystrixFallbackFactory.class)
//@RequestMapping("/api")
public interface ProductCatalogClient {

    @GetMapping("/api/productCatalogs/{id}")
    public ResponseEntity<ProductCatalog> getProductCatalog(@PathVariable(value = "id") long id);
}
