package com.youlog.youlog.domain.blog;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.member.MemberInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "blog")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "admin_id")
    @ManyToOne
    private MemberInfo admin;


    private Blog(MemberInfo member, String name){
        this.admin = member;
        this.name = name;
    }

    public static Blog createBlog(MemberInfo member, String name){
        return new Blog(member, name);
    }

    public void updateName(MemberInfo member, String updatedName) {
        checkAdmin(member);
        this.name = updatedName;
    }

    private void checkAdmin(MemberInfo member){
        if (!Objects.equals(this.admin.getId(), member.getId())){
            throw new IllegalArgumentException("수정 권한이 없는 사용자입니다.");
        }
    }

}
