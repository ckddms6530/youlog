package com.youlog.youlog.domain.category;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    private Long id;
    private String name;
    private Long parentId;
    private Long blogId;
    private CategoryHierarchy categoryHierarchy;

    public void updateHierarchy(CategoryHierarchy categoryHierarchy) {
        this.categoryHierarchy = categoryHierarchy;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public static Category createCategory(Long blogId, String name, Long parentId, CategoryHierarchy categoryHierarchy) {
        return new Category(blogId, name, parentId, categoryHierarchy);
    }

    public static class CategoryHierarchy {
        private Integer ref;
        private Integer level;
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

    private Category(Long blogId, String name, Long parentId, CategoryHierarchy categoryHierarchy) {
        this.blogId = blogId;
        this.name = name;
        this.parentId = parentId;
        this.categoryHierarchy = categoryHierarchy;
    }

}
