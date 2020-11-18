package com.silverfoxmedia.product.controller;

import com.silverfoxmedia.product.domain.model.Category;
import com.silverfoxmedia.product.domain.service.CategoryService;
import com.silverfoxmedia.product.resource.CategoryResource;
import com.silverfoxmedia.product.resource.SaveCategoryResource;
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

@Tag(name = "Categories", description = "Categories API")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Get All Categories", description = "Get All available Categories", responses = {
            @ApiResponse(
                    description = "All Categories",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/categories")
    public Page<CategoryResource> getAllCategories(Pageable pageable) {

        Page<Category> categoriesPage = categoryService.getAllCategories(pageable);
        List<CategoryResource> resources = categoriesPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/categories/{categoryId}")
    public CategoryResource getCategoryById(@PathVariable(value = "categoryId") Long categoryId) {
        return convertToResource(categoryService.getCategoryById(categoryId));
    }

    @PostMapping("/categories")
    public CategoryResource createCategory(
            @Valid @RequestBody SaveCategoryResource resource) {
        Category category = convertToEntity(resource);
        return convertToResource(categoryService.createCategory(category));

    }

    @PutMapping("/categories/{categoryId}")
    public CategoryResource updateCategory(@PathVariable Long categoryId,
                                   @Valid @RequestBody SaveCategoryResource resource) {
        Category category = convertToEntity(resource);
        return convertToResource(
                categoryService.updateCategory(categoryId, category));
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }


    private Category convertToEntity(SaveCategoryResource resource) {
        return mapper.map(resource, Category.class);
    }

    private CategoryResource convertToResource(Category entity) {
        return mapper.map(entity, CategoryResource.class);
    }
}
