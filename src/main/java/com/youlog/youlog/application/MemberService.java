package com.youlog.youlog.application;

import com.youlog.youlog.common.error.BusinessException;
import com.youlog.youlog.common.error.ErrorCode;
import com.youlog.youlog.domain.member.LocalMember;
import com.youlog.youlog.domain.member.MemberInfo;
import com.youlog.youlog.infrastructure.repository.member.LocalMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final LocalMemberRepository localMemberRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerMember(String email, String password, String nickname) {
        localMemberRepository.findByEmail(email).ifPresent(localMember -> {
            throw new BusinessException(ErrorCode.MEMBER_DUPLICATION);
        });
        MemberInfo memberInfo = new MemberInfo(nickname);
        String hashedPassword = passwordEncoder.encode(password);
        LocalMember localMember = LocalMember.builder()
                .email(email)
                .password(hashedPassword)
                .memberInfo(memberInfo)
                .build();
        localMemberRepository.save(localMember);
    }

}
