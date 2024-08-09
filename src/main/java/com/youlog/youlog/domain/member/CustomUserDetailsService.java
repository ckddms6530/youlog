package com.youlog.youlog.domain.member;

import com.youlog.youlog.application.repository.LocalMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final LocalMemberRepository localMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        log.debug("loadUserByUsername: {}", email);
        LocalMember localMember = localMemberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        MemberInfo memberInfo = localMember.getMemberInfo();
        memberInfo.updateLatestLoginAt();
        return new CustomUserDetails(localMember.getEmail(), localMember.getPassword(), List.of(() -> "ROLE_MEMBER"), memberInfo.getId(), memberInfo.getNickname());
    }
}
