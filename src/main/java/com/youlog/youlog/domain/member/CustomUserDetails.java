package com.youlog.youlog.domain.member;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUserDetails extends User {

    private final Long id;
    private final String nickname;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String nickname) {
        super(username, password, authorities);
        this.id = id;
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
