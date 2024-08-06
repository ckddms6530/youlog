package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.member.SocialMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMemberRepository extends JpaRepository<SocialMember, Long> {
}
