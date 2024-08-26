package com.youlog.youlog.domain.category;

import com.youlog.youlog.common.model.BaseEntity;
import com.youlog.youlog.domain.blog.Blog;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private Hierarchy hierarchy;

    @Builder
    private Category(Blog blog, String name, Category parentCategory, Hierarchy hierarchy) {
        this.blog = blog;
        this.name = name;
        this.parent = parentCategory;
        if (hierarchy == null) {
            this.hierarchy = Hierarchy.createCategoryHierarchy(0, 0, 0);
        } else {
            this.hierarchy = hierarchy;
        }
        this.hierarchy = hierarchy;
    }

    public static Category createRootCategory(Blog blog, String name) {
        return createParentCategory(name, blog, null);
    }

    public static Category createParentCategory(String name, Blog blog, Category lastRefCategory) {
        Hierarchy hierarchy = lastRefCategory != null ? lastRefCategory.getHierarchy().nextRef() : Hierarchy.ROOT;
        return new Category(blog, name, null, hierarchy);
    }

    public static Category createChildCategory(String name, Category parentCategory, Hierarchy hierarchy) {
        return new Category(parentCategory.getBlog(), name, parentCategory, hierarchy);
    }

    public void updateHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public void updateName(String name) {
        this.name = name;
    }

    @Embeddable
    @NoArgsConstructor
    @Getter
    public static class Hierarchy {
        public static final Hierarchy ROOT = new Hierarchy(0, 0, 0);
        @Column(name = "ref")
        private Integer ref;
        @Column(name = "level")
        private Integer level;
        @Column(name = "seq")
        private Integer seq;

        private Hierarchy(Integer ref, Integer level, Integer seq) {
            this.ref = ref;
            this.level = level;
            this.seq = seq;
        }

        public static Hierarchy createCategoryHierarchy(Integer ref, Integer level, Integer seq) {
            if (ref == null || level == null || seq == null) {
                throw new IllegalArgumentException("ref, level, seq null이 될 수 없습니다.");
            }
            return new Hierarchy(ref, level, seq);
        }

        public Hierarchy nextRef() {
            return new Hierarchy(this.ref + 1, this.level, this.seq);
        }

        public Hierarchy nextSeq() {
            return new Hierarchy(this.ref, this.level, this.seq + 1);
        }

        public Hierarchy firstChild() {
            return new Hierarchy(this.ref, this.level + 1, 0);
        }
    }


}
