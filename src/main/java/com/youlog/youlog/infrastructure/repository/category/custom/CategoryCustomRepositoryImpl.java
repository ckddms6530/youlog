package com.youlog.youlog.infrastructure.repository.category.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.youlog.youlog.domain.category.Category;
import com.youlog.youlog.domain.category.QCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CategoryCustomRepositoryImpl implements com.youlog.youlog.infrastructure.repository.category.custom.CategoryCustomRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<Category> findSortedCategoriesByBlogId(Long blogId) {
        QCategory category = QCategory.category;
        return queryFactory.selectFrom(category)
                .where(category.blog.id.eq(blogId))
                .orderBy(category.hierarchy.ref.asc())
                .orderBy(category.hierarchy.level.asc())
                .orderBy(category.hierarchy.seq.asc())
                .fetch();
    }

    @Override
    public Optional<Category.Hierarchy> findLastHierarchyByParentId(Long parentId) {
        QCategory category = QCategory.category;
        return Optional.ofNullable(queryFactory.select(category.hierarchy)
                .from(category)
                .where(category.parent.id.eq(parentId))
                .orderBy(category.hierarchy.level.desc())
                .orderBy(category.hierarchy.seq.desc())
                .fetchFirst());
    }
}
