package com.youlog.youlog.infrastructure.repository.visitor;

import com.youlog.youlog.domain.visitor.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
