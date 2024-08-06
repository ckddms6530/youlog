package com.youlog.youlog.domain.member;

public class LocalMember extends Member {

    private String email;
    private String password;

    protected LocalMember() {
    }

    private LocalMember(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private LocalMember(String email, String password, String nickname) {
        super(nickname);
        this.email = email;
        this.password = password;
    }

}
