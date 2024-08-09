package com.youlog.youlog.application;

import com.youlog.youlog.application.repository.LocalMemberRepository;
import com.youlog.youlog.application.repository.MemberInfoRepository;
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

    private final MemberInfoRepository memberInfoRepository;
    private final LocalMemberRepository localMemberRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerMember(String email, String password, String nickname) {
        MemberInfo memberInfo = new MemberInfo(nickname);
        memberInfoRepository.save(memberInfo);
        String hashedPassword = passwordEncoder.encode(password);
        LocalMember localMember = new LocalMember(email, hashedPassword, memberInfo);
        localMemberRepository.save(localMember);
    }
}
