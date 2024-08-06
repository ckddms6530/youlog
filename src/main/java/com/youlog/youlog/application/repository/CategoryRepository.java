package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
