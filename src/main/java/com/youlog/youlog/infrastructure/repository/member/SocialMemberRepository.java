package com.youlog.youlog.infrastructure.repository.member;

import com.youlog.youlog.domain.member.SocialMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMemberRepository extends JpaRepository<SocialMember, Long> {
}
