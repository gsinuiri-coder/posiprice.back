package com.silverfoxmedia.product.service;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import com.silverfoxmedia.product.domain.repository.CategoryRepository;
import com.silverfoxmedia.product.domain.repository.PromotedProductRepository;
import com.silverfoxmedia.product.domain.service.PromotedProductService;
import com.silverfoxmedia.product.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PromotedProductServiceImpl implements PromotedProductService {

    @Autowired
    private PromotedProductRepository promotedProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<PromotedProduct> getAllPromotedProductsByCategoryId(Long categoryId, Pageable pageable) {
        return promotedProductRepository.findByCategoryId(categoryId, pageable);
    }

    @Override
    public PromotedProduct getPromotedProductByIdAndCategoryId(Long categoryId, Long promotedProductId) {
        return promotedProductRepository.findByIdAndCategoryId(promotedProductId, categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PromotedProduct not found with Id " + promotedProductId +
                                " and CategoryId " + categoryId));
    }

    @Override
    public PromotedProduct createPromotedProduct(Long categoryId, PromotedProduct promotedProduct) {
        return categoryRepository.findById(categoryId).map(category -> {
            promotedProduct.setCategory(category);
            return promotedProductRepository.save(promotedProduct);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Category", "Id", categoryId));
    }

    @Override
    public PromotedProduct updatePromotedProduct(Long categoryId, Long promotedProductId, PromotedProduct promotedProductDetails) {
        if(!categoryRepository.existsById(categoryId))
            throw new ResourceNotFoundException("Category", "Id", categoryId);

        return promotedProductRepository.findById(promotedProductId).map(promotedProduct -> {
            promotedProduct.setName(promotedProductDetails.getName());
            return promotedProductRepository.save(promotedProduct);
        }).orElseThrow(() -> new ResourceNotFoundException("PromotedProduct", "Id", promotedProductId));
    }

    @Override
    public ResponseEntity<?> deletePromotedProduct(Long categoryId, Long promotedProductId) {
        return promotedProductRepository.findByIdAndCategoryId(promotedProductId, categoryId).map(promotedProduct -> {
            promotedProductRepository.delete(promotedProduct);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "PromotedProduct not found with Id " + promotedProductId + " and CategoryId " + categoryId));
    }
}
