package com.youlog.youlog.application;

import com.youlog.youlog.application.repository.LocalMemberRepository;
import com.youlog.youlog.domain.member.LocalMember;
import com.youlog.youlog.domain.member.MemberInfo;
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
