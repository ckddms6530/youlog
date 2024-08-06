package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepositroy extends JpaRepository<Comment, Long> {
}
