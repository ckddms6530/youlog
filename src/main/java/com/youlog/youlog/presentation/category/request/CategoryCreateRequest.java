package com.youlog.youlog.presentation.category.request;

public record CategoryCreateRequest(Long blogId, String name, Long parentId) {
}
