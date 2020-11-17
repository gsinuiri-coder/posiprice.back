package com.silverfoxmedia.product.domain.repository;

import com.silverfoxmedia.product.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long > {
}
