package com.youlog.youlog.domain.blog;

import com.youlog.youlog.common.error.BusinessException;
import com.youlog.youlog.common.error.ErrorCode;
import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.member.MemberInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "blog")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog extends BaseEntity {

    private static final int BLOG_CREATION_LIMIT = 1;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "admin_id")
    @ManyToOne
    private MemberInfo admin;

    @Builder
    private Blog(MemberInfo member, String name) {
        this.admin = member;
        this.name = name;
    }

    public static void checkCreationLimit(int blogCount) {
        if (blogCount >= BLOG_CREATION_LIMIT) {
            throw new BusinessException(ErrorCode.BLOG_CREATION_LIMIT);
        }
    }

    public void updateName(MemberInfo member, String updatedName) {
        checkAdmin(member);
        this.name = updatedName;
    }

    private void checkAdmin(MemberInfo member) {
        if (!Objects.equals(this.admin.getId(), member.getId())) {
            throw new BusinessException(ErrorCode.ACCESS_DENIED);
        }
    }

}
