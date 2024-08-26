package com.youlog.youlog.common.security;

import com.youlog.youlog.common.error.BusinessException;
import com.youlog.youlog.common.error.ErrorCode;
import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.member.LocalMember;
import com.youlog.youlog.domain.member.MemberInfo;
import com.youlog.youlog.infrastructure.repository.blog.BlogRepository;
import com.youlog.youlog.infrastructure.repository.member.LocalMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final LocalMemberRepository localMemberRepository;
    private final BlogRepository blogRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        log.debug("loadUserByUsername: {}", email);

        LocalMember localMember = localMemberRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

        MemberInfo memberInfo = localMember.getMemberInfo();
        memberInfo.updateLatestLoginAt();

        Map<Long, String> blogMap = blogRepository.findAllByAdmin_Id(memberInfo.getId()).stream()
                .collect(Collectors.toMap(BaseEntity::getId, Blog::getName));

        return new CustomUserDetails(
                localMember.getEmail(),
                localMember.getPassword(),
                List.of(() -> "ROLE_MEMBER"),
                memberInfo.getId(),
                memberInfo.getNickname(),
                blogMap
        );
    }
}
