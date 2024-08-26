package com.youlog.youlog.infrastructure.repository.comment;

import com.youlog.youlog.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositroy extends JpaRepository<Comment, Long> {
}
