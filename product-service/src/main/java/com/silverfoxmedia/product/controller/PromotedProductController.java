package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.domain.model.PromotedProduct;
import com.silverfoxmedia.product.domain.service.PromotedProductService;
import com.silverfoxmedia.product.resource.PromotedProductResource;
import com.silverfoxmedia.product.resource.SavePromotedProductResource;
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

@Tag(name = "Promoted Products", description = "Promoted Products API")
@RestController
@RequestMapping("/api")
public class PromotedProductController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PromotedProductService promotedProductService;

    @Operation(summary = "Get All PromotedProducts", description = "Get All available PromotedProducts", responses = {
            @ApiResponse(
                    description = "All PromotedProducts",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/promotedProducts")
    public Page<PromotedProductResource> getAllPromotedProducts(Pageable pageable) {

        Page<PromotedProduct> promotedProductsPage = promotedProductService.getAllPromotedProducts(pageable);
        List<PromotedProductResource> resources = promotedProductsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/promotedProducts/{promotedProductId}")
    public PromotedProductResource getPromotedProductById(@PathVariable(value = "promotedProductId") Long promotedProductId) {
        return convertToResource(promotedProductService.getPromotedProductById(promotedProductId));
    }

    @PostMapping("/promotedProducts")
    public PromotedProductResource createPromotedProduct(
            @Valid @RequestBody SavePromotedProductResource resource) {
        PromotedProduct promotedProduct = convertToEntity(resource);
        return convertToResource(promotedProductService.createPromotedProduct(promotedProduct));

    }

    @PutMapping("/promotedProducts/{promotedProductId}")
    public PromotedProductResource updatePromotedProduct(@PathVariable Long promotedProductId,
                                                       @Valid @RequestBody SavePromotedProductResource resource) {
        PromotedProduct promotedProduct = convertToEntity(resource);
        return convertToResource(
                promotedProductService.updatePromotedProduct(promotedProductId, promotedProduct));
    }

    @DeleteMapping("/promotedProducts/{promotedProductId}")
    public ResponseEntity<?> deletePromotedProduct(@PathVariable Long promotedProductId) {
        return promotedProductService.deletePromotedProduct(promotedProductId);
    }


    private PromotedProduct convertToEntity(SavePromotedProductResource resource) {
        return mapper.map(resource, PromotedProduct.class);
    }

    private PromotedProductResource convertToResource(PromotedProduct entity) {
        return mapper.map(entity, PromotedProductResource.class);
    }
}
