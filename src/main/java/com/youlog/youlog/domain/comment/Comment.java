package com.youlog.youlog.domain.comment;


import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.member.MemberInfo;
import com.youlog.youlog.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private MemberInfo writer;
    @Column(name = "content")
    private String content;
    @Embedded
    private CommentHierarchy commentHierarchy;

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentHierarchy {
        @Column(name = "ref")
        private Integer ref;
        @Column(name = "level")
        private Integer level;
        @Column(name = "seq")
        private Integer seq;

        private CommentHierarchy(Integer ref, Integer level, Integer seq) {
            this.ref = ref;
            this.level = level;
            this.seq = seq;
        }
    }

    public static CommentHierarchy createCategoryHierarchy(Integer ref, Integer level, Integer seq) {
        if (ref == null || level == null || seq == null) {
            throw new IllegalArgumentException("ref, level, seq null이 될 수 없습니다.");
        }
        return new CommentHierarchy(ref, level, seq);
    }

    public static Comment createComment(Post postId, Comment parent, MemberInfo memberInfo, String content, CommentHierarchy commentHierarchy) {
        return new Comment(postId, parent, memberInfo, content, commentHierarchy);
    }

    private Comment(Post post, Comment parent, MemberInfo memberInfo, String content, CommentHierarchy commentHierarchy) {
        this.post = post;
        this.parent = parent;
        this.writer = memberInfo;
        this.content = content;
        this.commentHierarchy = commentHierarchy;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
