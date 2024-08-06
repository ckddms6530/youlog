package com.youlog.youlog.domain.visitor;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visitor_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VisitorLog extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "referer")
    private String referer;

    public VisitorLog(Visitor visitor, Post post, String referer) {
        this.visitor = visitor;
        this.post = post;
        this.referer = referer;
    }

}
