package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Optional<Blog> findByAdmin_Id(Long id);
}
