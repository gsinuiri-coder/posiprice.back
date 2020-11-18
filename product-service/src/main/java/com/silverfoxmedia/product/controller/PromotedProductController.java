package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import com.silverfoxmedia.product.domain.service.PromotedProductService;
import com.silverfoxmedia.product.resource.PromotedProductResource;
import com.silverfoxmedia.product.resource.SavePromotedProductResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Promote Products", description = "Promote Products API")
@RestController
@RequestMapping("/api")
public class PromotedProductController {

    @Autowired
    private PromotedProductService promotedProductService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/categories/{categoryId}/promotedProducts")
    public Page<PromotedProductResource> getAllPromotedProductsByCategoryId(
            @PathVariable(value = "categoryId") Long categoryId,
            Pageable pageable) {
        Page<PromotedProduct> promotedProductPage = promotedProductService.getAllPromotedProductsByCategoryId(categoryId, pageable);
        List<PromotedProductResource> resources = promotedProductPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/categories/{categoryId}/promotedProducts/{promotedProductId}")
    public PromotedProductResource getPromotedProductByIdAndCategoryId(
            @PathVariable(name = "categoryId") Long categoryId,
            @PathVariable(name = "promotedProductId") Long promotedProductId) {
        return convertToResource(promotedProductService.getPromotedProductByIdAndCategoryId(categoryId, promotedProductId));
    }

    @PostMapping("/categories/{categoryId}/promotedProducts")
    public PromotedProductResource createPromotedProduct(
            @PathVariable(value = "categoryId") Long categoryId,
            @Valid @RequestBody SavePromotedProductResource resource) {
        return convertToResource(promotedProductService.createPromotedProduct(categoryId,
                convertToEntity(resource)));
    }

    @PutMapping("/categories/{categoryId}/promotedProducts/{promotedProductId}")
    public PromotedProductResource updatePromotedProduct(
            @PathVariable (value = "categoryId") Long categoryId,
            @PathVariable (value = "promotedProductId") Long promotedProductId,
            @Valid @RequestBody SavePromotedProductResource resource) {
        return convertToResource(promotedProductService.updatePromotedProduct(categoryId, promotedProductId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/categories/{categoryId}/promotedProducts/{promotedProductId}")
    public ResponseEntity<?> deletePromotedProduct(
            @PathVariable (value = "categoryId") Long categoryId,
            @PathVariable (value = "promotedProductId") Long promotedProductId) {
        return promotedProductService.deletePromotedProduct(categoryId, promotedProductId);
    }

    private PromotedProduct convertToEntity(SavePromotedProductResource resource) {
        return mapper.map(resource, PromotedProduct.class);
    }

    private PromotedProductResource convertToResource(PromotedProduct entity) {
        return mapper.map(entity, PromotedProductResource.class);
    }
}
