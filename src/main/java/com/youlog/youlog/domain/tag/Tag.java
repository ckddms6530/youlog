package com.youlog.youlog.domain.tag;

import com.youlog.youlog.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag extends BaseEntity {

    @Column(name = "name")
    private String name;
    private Tag(String name) {
        this.name = name;
    }

    public static Tag createTag(String name) {
        return new Tag(name);
    }

}
