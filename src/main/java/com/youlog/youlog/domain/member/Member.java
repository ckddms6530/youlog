package com.youlog.youlog.domain.member;

import java.time.LocalDateTime;

abstract class Member {
    private Long id;
    private String nickname;
    private LocalDateTime lastLoginAt;
    protected Member(){
    }

    protected Member(String nickname){
        this.nickname = nickname;
    }
    public void updateNickname(String nickname){
        this.nickname = nickname;
    }

}
