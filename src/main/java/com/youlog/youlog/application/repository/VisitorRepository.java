package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.visitor.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
