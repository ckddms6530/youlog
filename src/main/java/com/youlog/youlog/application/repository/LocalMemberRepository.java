package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.member.LocalMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalMemberRepository extends JpaRepository<LocalMember, Long> {
}
