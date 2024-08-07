package com.youlog.youlog.domain.member;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberInfo extends BaseEntity {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "latest_login_at")
    private LocalDateTime latestLoginAt;

    public MemberInfo(String nickname){
        this.nickname = nickname;
    }
    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
    public void updateLatestLoginAt(){
        this.latestLoginAt = LocalDateTime.now();
    }
}
