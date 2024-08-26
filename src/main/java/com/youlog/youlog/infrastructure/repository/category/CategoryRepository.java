package com.youlog.youlog.infrastructure.repository.category;

import com.youlog.youlog.domain.category.Category;
import com.youlog.youlog.infrastructure.repository.category.custom.CategoryCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryCustomRepository {

    List<Category> findAllByBlog_Id(Long blogId);

    Optional<Category> findFirstByBlog_IdOrderByHierarchy_RefDesc(Long blogId);

}
