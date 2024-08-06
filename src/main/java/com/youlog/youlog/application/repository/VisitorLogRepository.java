package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.visitor.VisitorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorLogRepository extends JpaRepository<VisitorLog, Long> {
}
