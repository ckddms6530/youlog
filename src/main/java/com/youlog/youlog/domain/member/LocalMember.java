package com.youlog.youlog.domain.member;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.member.exception.LoginFaildException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "local_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocalMember extends BaseEntity {

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberInfo memberInfo;

    public LocalMember(String email, String password, MemberInfo memberInfo) {
        this.email = email;
        this.password = password;
        this.memberInfo = memberInfo;
    }

    public MemberInfo login(String email, String password) {
        if (!this.email.equals(email) || !this.password.equals(password)) {
            throw new LoginFaildException();
        }
        this.memberInfo.updateLatestLoginAt();
        return this.memberInfo;
    }
}
