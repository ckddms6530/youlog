package com.youlog.youlog.domain.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "local_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocalMember {

    @Id
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberInfo memberInfo;

    @Builder
    private LocalMember(String email, String password, MemberInfo memberInfo) {
        this.email = email;
        this.password = password;
        this.memberInfo = memberInfo;
    }
}
