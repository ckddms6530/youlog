package com.youlog.youlog.domain.post;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.category.Category;
import com.youlog.youlog.domain.member.MemberInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    @ManyToOne
    @JoinColumn(name = "writer_id")
    private MemberInfo writer;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "is_hided")
    private boolean hided;

    @Builder
    private Post(String title, String content, Blog blog, MemberInfo writer, Category category, boolean hided) {
        this.title = title;
        this.content = content;
        this.blog = blog;
        this.writer = writer;
        this.category = category;
        this.hided = hided;
    }


}
