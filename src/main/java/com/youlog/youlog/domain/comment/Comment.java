package com.youlog.youlog.domain.comment;


public class Comment {

    private Long id;
    private Long postId;
    private Long parentId;
    private Long writerId;
    private String content;
    private CommentHierarchy commentHierarchy;
    protected Comment() {
    }

    public static class CommentHierarchy {
        private Integer ref;
        private Integer level;
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

    public static Comment createComment(Long postId, Long parentId, Long writerId, String content, CommentHierarchy commentHierarchy) {
        return new Comment(postId, parentId, writerId, content, commentHierarchy);
    }

    private Comment(Long postId, Long parentId, Long writerId, String content, CommentHierarchy commentHierarchy) {
        this.postId = postId;
        this.parentId = parentId;
        this.writerId = writerId;
        this.content = content;
        this.commentHierarchy = commentHierarchy;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
