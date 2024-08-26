package com.youlog.youlog.common.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

@Getter
public class CustomUserDetails extends User {

    private final Long id;
    private final String nickname;
    private final Map<Long, String> blogMap;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String nickname, Map<Long, String> blogMap) {
        super(username, password, authorities);
        this.id = id;
        this.nickname = nickname;
        this.blogMap = blogMap;
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
