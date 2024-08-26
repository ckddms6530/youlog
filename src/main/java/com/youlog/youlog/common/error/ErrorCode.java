package com.youlog.youlog.common.error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    BLOG_CREATION_LIMIT(400, "BLOG-001", "블로그 생성 제한을 초과"),
    BLOG_NOT_FOUND(404, "BLOG-002", "블로그를 찾을 수 없음"),
    MEMBER_NOT_FOUND(404, "MEMBER-001", "회원를 찾을 수 없음"),
    MEMBER_DUPLICATION(400, "MEMBER-002", "이미 존재하는 회원"),
    INVALID_INPUT_VALUE(400, "COMMON-001", "입력 값이 잘못된 경우"),
    INTERNAL_SERVER_ERROR(500, "COMMON-002", "내부 서버 오류"),
    ACCESS_DENIED(403, "COMMON-003", "접근 권한이 없는 경우"), CATEGORY_NOT_FOUND(404, "CATE-001", "카테고리를 찾을 수 없음");


    private final int status;
    private final String code;
    private final String reason;

    ErrorCode(int status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }

}
