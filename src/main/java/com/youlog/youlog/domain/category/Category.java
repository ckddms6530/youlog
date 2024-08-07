package com.youlog.youlog.domain.category;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.blog.Blog;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    @Embedded
    private CategoryHierarchy categoryHierarchy;

    public void updateHierarchy(CategoryHierarchy categoryHierarchy) {
        this.categoryHierarchy = categoryHierarchy;
    }

    public void updateName(String name) {
        this.name = name;
    }


    @Embeddable
    @NoArgsConstructor
    public static class CategoryHierarchy {
        @Column(name = "ref")
        private Integer ref;
        @Column(name = "level")
        private Integer level;
        @Column(name = "seq")
        private Integer seq;

        private CategoryHierarchy(Integer ref, Integer level, Integer seq) {
            this.ref = ref;
            this.level = level;
            this.seq = seq;
        }

        public static CategoryHierarchy createCategoryHierarchy(Integer ref, Integer level, Integer seq) {
            if (ref == null || level == null || seq == null) {
                throw new IllegalArgumentException("ref, level, seq null이 될 수 없습니다.");
            }
            return new CategoryHierarchy(ref, level, seq);
        }
    }

    public Category(Blog blog, String name, Category parentCategory, CategoryHierarchy categoryHierarchy) {
        this.blog = blog;
        this.name = name;
        this.parent = parentCategory;
        this.categoryHierarchy = categoryHierarchy;
    }

}
