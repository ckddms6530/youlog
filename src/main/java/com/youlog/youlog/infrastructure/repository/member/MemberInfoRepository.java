package com.youlog.youlog.infrastructure.repository.member;

import com.youlog.youlog.domain.member.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
