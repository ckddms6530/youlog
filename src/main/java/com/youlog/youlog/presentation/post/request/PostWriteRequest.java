package com.youlog.youlog.presentation.post.request;

import lombok.Getter;

@Getter
public class PostWriteRequest {
    private String title = "tmp";
    private String content;
    private Integer blogId;
    private Integer writerId;
    private Integer categoryId = 0;
    private boolean hided;
}
