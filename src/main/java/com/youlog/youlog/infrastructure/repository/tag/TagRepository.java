package com.youlog.youlog.infrastructure.repository.tag;

import com.youlog.youlog.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
