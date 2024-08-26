package com.youlog.youlog.infrastructure.repository.category.custom;

import com.youlog.youlog.domain.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryCustomRepository {

    List<Category> findSortedCategoriesByBlogId(Long blogId);

    Optional<Category.Hierarchy> findLastHierarchyByParentId(Long categoryId);
}
