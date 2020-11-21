package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.domain.model.ProductCatalog;
import com.silverfoxmedia.product.domain.service.ProductCatalogService;
import com.silverfoxmedia.product.resource.ProductCatalogResource;
import com.silverfoxmedia.product.resource.SaveProductCatalogResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    private ModelMapper mapper;

    @Autowired
    private ProductCatalogService productCatalogService;

    @Operation(summary = "Get All ProductCatalogs", description = "Get All available ProductCatalogs", responses = {
            @ApiResponse(
                    description = "All ProductCatalogs",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/productCatalogs")
    public Page<ProductCatalogResource> getAllProductCatalogs(Pageable pageable) {

        Page<ProductCatalog> productCatalogsPage = productCatalogService.getAllProductCatalogs(pageable);
        List<ProductCatalogResource> resources = productCatalogsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/productCatalogs/{productCatalogId}")
    public ProductCatalogResource getProductCatalogById(@PathVariable(value = "productCatalogId") Long productCatalogId) {
        return convertToResource(productCatalogService.getProductCatalogById(productCatalogId));
    }

    @PostMapping("/productCatalogs")
    public ProductCatalogResource createProductCatalog(
            @Valid @RequestBody SaveProductCatalogResource resource) {
        ProductCatalog productCatalog = convertToEntity(resource);
        return convertToResource(productCatalogService.createProductCatalog(productCatalog));

    }

    @PutMapping("/productCatalogs/{productCatalogId}")
    public ProductCatalogResource updateProductCatalog(@PathVariable Long productCatalogId,
                                   @Valid @RequestBody SaveProductCatalogResource resource) {
        ProductCatalog productCatalog = convertToEntity(resource);
        return convertToResource(
                productCatalogService.updateProductCatalog(productCatalogId, productCatalog));
    }

    @DeleteMapping("/productCatalogs/{productCatalogId}")
    public ResponseEntity<?> deleteProductCatalog(@PathVariable Long productCatalogId) {
        return productCatalogService.deleteProductCatalog(productCatalogId);
    }


    private ProductCatalog convertToEntity(SaveProductCatalogResource resource) {
        return mapper.map(resource, ProductCatalog.class);
    }

    private ProductCatalogResource convertToResource(ProductCatalog entity) {
        return mapper.map(entity, ProductCatalogResource.class);
    }

}
