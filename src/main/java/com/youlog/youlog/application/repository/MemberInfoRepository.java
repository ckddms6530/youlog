package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.member.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {
}
