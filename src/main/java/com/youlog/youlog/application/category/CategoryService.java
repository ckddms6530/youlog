package com.youlog.youlog.application.category;

import com.youlog.youlog.common.error.BusinessException;
import com.youlog.youlog.common.error.ErrorCode;
import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.category.Category;
import com.youlog.youlog.infrastructure.repository.blog.BlogRepository;
import com.youlog.youlog.infrastructure.repository.category.CategoryRepository;
import com.youlog.youlog.presentation.category.request.CategoryCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryCreateRequest request) {
        Blog blog = blogRepository.findById(request.blogId()).orElseThrow(() -> new BusinessException(ErrorCode.BLOG_NOT_FOUND));
        Category category;
        if (request.parentId() == null) {
            category = createParentCategory(request.name(), blog);
        } else {
            category = createChildCategory(request.name(), request.parentId(), blog);
        }
        categoryRepository.save(category);
    }

    private Category createParentCategory(String name, Blog blog) {
        Optional<Category> lastRefCategory = categoryRepository.findFirstByBlog_IdOrderByHierarchy_RefDesc(blog.getId());
        Category category;
        if (lastRefCategory.isPresent()) {
            Category.Hierarchy hierarchy = lastRefCategory.get().getHierarchy().nextRef();
            category = Category.builder()
                    .hierarchy(hierarchy)
                    .blog(blog)
                    .name(name)
                    .build();
        } else {
            category = Category.builder()
                    .hierarchy(Category.Hierarchy.ROOT)
                    .name(name)
                    .blog(blog)
                    .build();
        }
        return category;
    }

    private Category createChildCategory(String name, Long parentId, Blog blog) {
        Category parentCategory = categoryRepository.findById(parentId).orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
        Category.Hierarchy hierarchy = categoryRepository.findLastHierarchyByParentId(parentId).orElseGet(() -> parentCategory.getHierarchy().firstChild());

        return Category.builder()
                .parentCategory(parentCategory)
                .hierarchy(hierarchy)
                .name(name)
                .blog(blog)
                .build();
    }

    public List<Category> getCategoryList(Long blogId) {
        return categoryRepository.findSortedCategoriesByBlogId(blogId);
    }
}

