package com.youlog.youlog.infrastructure.repository.blog;

import com.youlog.youlog.domain.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    int countByAdmin_Id(Long memberId);

    List<Blog> findAllByAdmin_Id(Long memberId);
}
