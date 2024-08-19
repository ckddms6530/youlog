package com.youlog.youlog.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BLOG_CREATION_LIMIT(400, "BLOG-001", "블로그 생성 제한을 초과"),
    INVALID_INPUT_VALUE(400, "COMMON-001", "입력 값이 잘못된 경우"),
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "내부 서버 오류"),
    ACCESS_DENIED(403, "COMMON-003", "접근 권한이 없는 경우");


    private final int status;
    private final String code;
    private final String reason;

    ErrorCode(int status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

}
