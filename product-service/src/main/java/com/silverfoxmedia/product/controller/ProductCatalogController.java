package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import com.silverfoxmedia.product.domain.service.ProductCatalogService;
import com.silverfoxmedia.product.resource.ProductCatalogResource;
import com.silverfoxmedia.product.resource.SaveProductCatalogResource;
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

@Tag(name = "Product Catalogs", description = "Product Catalogs API")
@RestController
@RequestMapping("/api")
public class ProductCatalogController {

    @Autowired
    private ProductCatalogService productCatalogService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/categories/{categoryId}/productCatalogs")
    public Page<ProductCatalogResource> getAllProductCatalogsByCategoryId(
            @PathVariable(value = "categoryId") Long categoryId,
            Pageable pageable) {
        Page<ProductCatalog> productCatalogPage = productCatalogService.getAllProductCatalogsByCategoryId(categoryId, pageable);
        List<ProductCatalogResource> resources = productCatalogPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/categories/{categoryId}/productCatalogs/{productCatalogId}")
    public ProductCatalogResource getProductCatalogByIdAndCategoryId(
            @PathVariable(name = "categoryId") Long categoryId,
            @PathVariable(name = "productCatalogId") Long productCatalogId) {
        return convertToResource(productCatalogService.getProductCatalogByIdAndCategoryId(categoryId, productCatalogId));
    }

    @PostMapping("/categories/{categoryId}/productCatalogs")
    public ProductCatalogResource createProductCatalog(
            @PathVariable(value = "categoryId") Long categoryId,
            @Valid @RequestBody SaveProductCatalogResource resource) {
        return convertToResource(productCatalogService.createProductCatalog(categoryId,
                convertToEntity(resource)));
    }

    @PutMapping("/categories/{categoryId}/productCatalogs/{productCatalogId}")
    public ProductCatalogResource updateProductCatalog(
            @PathVariable (value = "categoryId") Long categoryId,
            @PathVariable (value = "productCatalogId") Long productCatalogId,
            @Valid @RequestBody SaveProductCatalogResource resource) {
        return convertToResource(productCatalogService.updateProductCatalog(categoryId, productCatalogId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/categories/{categoryId}/productCatalogs/{productCatalogId}")
    public ResponseEntity<?> deleteProductCatalog(
            @PathVariable (value = "categoryId") Long categoryId,
            @PathVariable (value = "productCatalogId") Long productCatalogId) {
        return productCatalogService.deleteProductCatalog(categoryId, productCatalogId);
    }

    private ProductCatalog convertToEntity(SaveProductCatalogResource resource) {
        return mapper.map(resource, ProductCatalog.class);
    }

    private ProductCatalogResource convertToResource(ProductCatalog entity) {
        return mapper.map(entity, ProductCatalogResource.class);
    }

}
