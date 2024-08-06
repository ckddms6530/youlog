package com.youlog.youlog.domain.tag;

import lombok.Getter;

@Getter
public class Tag {
    private Long id;
    private String name;
    protected Tag() {
    }
    private Tag(String name) {
        this.name = name;
    }

    public static Tag createTag(String name) {
        return new Tag(name);
    }

}
