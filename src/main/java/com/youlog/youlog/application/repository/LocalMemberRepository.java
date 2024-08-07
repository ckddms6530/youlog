package com.youlog.youlog.application.repository;

import com.youlog.youlog.domain.member.LocalMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalMemberRepository extends JpaRepository<LocalMember, Long> {

    Optional<LocalMember> findByEmail(String email);
}
