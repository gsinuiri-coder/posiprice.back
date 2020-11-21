package com.silverfoxmedia.product.service;

import com.silverfoxmedia.product.domain.model.Category;
import com.silverfoxmedia.product.domain.model.ProductCatalog;
import com.silverfoxmedia.product.domain.repository.CategoryRepository;
import com.silverfoxmedia.product.domain.repository.ProductCatalogRepository;
import com.silverfoxmedia.product.domain.service.ProductCatalogService;
import com.silverfoxmedia.product.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Override
    public Page<ProductCatalog> getAllProductCatalogs(Pageable pageable) {
        return productCatalogRepository.findAll(pageable);
    }

    @Override
    public ProductCatalog getProductCatalogById(Long productCatalogId) {
        return productCatalogRepository.findById(productCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ProductCatalog", "Id", productCatalogId));
    }

    @Override
    public ProductCatalog createProductCatalog(ProductCatalog productCatalog) {


        return productCatalogRepository.save(productCatalog);
    }

    @Override
    public ProductCatalog updateProductCatalog(Long productCatalogId, ProductCatalog productCatalogRequest) {
        ProductCatalog productCatalog = productCatalogRepository.findById(productCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ProductCatalog", "Id", productCatalogId));

        productCatalog.setName(productCatalogRequest.getName());

        return productCatalogRepository.save(productCatalog);
    }

    @Override
    public ResponseEntity<?> deleteProductCatalog(Long productCatalogId) {
        ProductCatalog productCatalog = productCatalogRepository.findById(productCatalogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ProductCatalog", "Id", productCatalogId));
        productCatalogRepository.delete(productCatalog);
        return ResponseEntity.ok().build();
    }

}
