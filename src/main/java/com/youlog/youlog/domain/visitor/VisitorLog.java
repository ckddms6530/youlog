package com.youlog.youlog.domain.visitor;

public class VisitorLog {
    private Long id;
    private Long visitorId;
    private Long postId;
    private String referer;

    protected VisitorLog() {
    }

    private VisitorLog(Long visitorId, Long postId, String referer) {
        this.visitorId = visitorId;
        this.postId = postId;
        this.referer = referer;
    }

    public static VisitorLog createVisitorLog(Long visitorId, Long postId, String referer) {
        return new VisitorLog(visitorId, postId, referer);
    }

}
