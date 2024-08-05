package com.youlog.youlog.domain.blog;

import java.util.Objects;

public class Blog {

    private Long id;
    private String name;
    private Long adminId;

    protected Blog(){
    }

    private Blog(Long adminId, String name){
        this.adminId = adminId;
        this.name = name;
    }

    public static Blog createBlog(Long memberId, String name){
        return new Blog(memberId, name);
    }

    public void updateName(Long memberId, String updatedName) {
        if (!Objects.equals(adminId, memberId)){
            throw new IllegalArgumentException("수정 권한이 없는 사용자입니다.");
        }
        this.name = updatedName;
    }

}
