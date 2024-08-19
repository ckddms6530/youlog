package com.youlog.youlog.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BLOG_CREATION_LIMIT(400, "BLOG-0001", "이미 블로그를 개설한 경우"),
    INVALID_INPUT_VALUE(400, "COMMON-0001", "입력 값이 잘못된 경우"),
    INTERNAL_SERVER_ERROR(500, "COMMON-0002", "서버에서 처리할 수 없는 경우");

    private final int status;
    private final String code;
    private final String reason;

    ErrorCode(int status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

}
