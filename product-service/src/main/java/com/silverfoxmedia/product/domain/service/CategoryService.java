package com.silverfoxmedia.product.domain.service;

import com.silverfoxmedia.product.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    Page<Category> getAllCategories(Pageable pageable);
    Category getCategoryById(Long categoryId);
    Category createCategory(Category category);
    Category updateCategory(Long categoryId, Category categoryRequest);
    ResponseEntity<?> deleteCategory(Long categoryId);
}
