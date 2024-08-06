package com.youlog.youlog.domain.post;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
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
    @Column(name = "blog_id")
    private Long blogId;
    @Column(name = "writer_id")
    private Long writerId;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "is_hided")
    private boolean hided;

    private Post(String title, String content, Long blogId, Long writerId, Long categoryId, boolean hided) {
        this.title = title;
        this.content = content;
        this.blogId = blogId;
        this.writerId = writerId;
        this.categoryId = categoryId;
        this.hided = hided;
    }

    public static Post createPost(String title, String content, Long blogId, Long writerId, Long categoryId, boolean hided) {
        return new Post(title, content, blogId, writerId, categoryId, hided);
    }

    public void updatePost(String title, String content, Long categoryId, boolean hided) {
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.hided = hided;
    }

}
