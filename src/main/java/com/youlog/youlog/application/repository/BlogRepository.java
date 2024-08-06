package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
