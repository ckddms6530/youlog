package com.youlog.youlog.infrastructure.repository.post;

import com.youlog.youlog.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
