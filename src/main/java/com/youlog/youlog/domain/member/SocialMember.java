package com.youlog.youlog.domain.member;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "social_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SocialMember extends BaseEntity {

    @JoinColumn(name = "social_provider_id")
    @ManyToOne
    private SocialProvider socialProvider;
    @JoinColumn(name = "social_account_id")
    private String socialAccountId;
    @MapsId
    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberInfo memberInfo;

    public SocialMember(SocialProvider socialProvider, String socialAccountId, MemberInfo memberInfo) {
        this.socialProvider = socialProvider;
        this.socialAccountId = socialAccountId;
        this.memberInfo = memberInfo;
    }
}
