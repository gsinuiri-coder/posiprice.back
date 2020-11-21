package com.silverfoxmedia.collectivity.client;


import com.silverfoxmedia.collectivity.domain.model.ProductCatalog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductCatalogHystrixFallbackFactory implements ProductCatalogClient{

    @Override
    public ResponseEntity<ProductCatalog> getProductCatalog(long id) {

        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setName("none");
        productCatalog.setDescription("none");
        productCatalog.setPrice(null);
        productCatalog.setActive(false);

        return ResponseEntity.ok(productCatalog);
    }
}
