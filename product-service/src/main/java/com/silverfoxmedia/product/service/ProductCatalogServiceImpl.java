package com.silverfoxmedia.product.service;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import com.silverfoxmedia.product.domain.repository.CategoryRepository;
import com.silverfoxmedia.product.domain.repository.ProductCatalogRepository;
import com.silverfoxmedia.product.domain.service.ProductCatalogService;
import com.silverfoxmedia.product.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    @Autowired
    private ProductCatalogRepository productCatalogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<ProductCatalog> getAllProductCatalogsByCategoryId(Long categoryId, Pageable pageable) {
        return productCatalogRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public ProductCatalog getProductCatalogByIdAndCategoryId(Long categoryId, Long productCatalogId) {
        return productCatalogRepository.findByIdAndCategoryId(productCatalogId, categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ProductCatalog not found with Id " + productCatalogId +
                                " and CategoryId " + categoryId));
    }

    @Override
    public ProductCatalog createProductCatalog(Long categoryId, ProductCatalog productCatalog) {
        return categoryRepository.findById(categoryId).map(category -> {
            productCatalog.setCategory(category);
            return productCatalogRepository.save(productCatalog);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Category", "Id", categoryId));
    }

    @Override
    public ProductCatalog updateProductCatalog(Long categoryId, Long productCatalogId, ProductCatalog productCatalogDetails) {
        if(!categoryRepository.existsById(categoryId))
            throw new ResourceNotFoundException("Category", "Id", categoryId);

        return productCatalogRepository.findById(productCatalogId).map(productCatalog -> {
            productCatalog.setName(productCatalogDetails.getName());
            return productCatalogRepository.save(productCatalog);
        }).orElseThrow(() -> new ResourceNotFoundException("ProductCatalog", "Id", productCatalogId));
    }

    @Override
    public ResponseEntity<?> deleteProductCatalog(Long categoryId, Long productCatalogId) {
        return productCatalogRepository.findByIdAndCategoryId(productCatalogId, categoryId).map(productCatalog -> {
            productCatalogRepository.delete(productCatalog);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "ProductCatalog not found with Id " + productCatalogId + " and CategoryId " + categoryId));
    }
}
