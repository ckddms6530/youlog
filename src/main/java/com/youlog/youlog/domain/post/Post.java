package com.youlog.youlog.domain.post;

import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long blogId;
    private Long writerId;
    private Long categoryId;
    private boolean hided;

    protected Post() {
    }

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
