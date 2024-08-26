package com.youlog.youlog.application;

import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.member.MemberInfo;
import com.youlog.youlog.infrastructure.repository.blog.BlogRepository;
import com.youlog.youlog.infrastructure.repository.member.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberInfoRepository memberInfoRepository;

    public Blog createBlog(String title, Long memberId) {
        MemberInfo memberInfo = memberInfoRepository.getReferenceById(memberId);
        Blog.checkCreationLimit(blogRepository.countByAdmin_Id(memberId));
        Blog blog = Blog.builder()
                .name(title)
                .member(memberInfo)
                .build();
        return blogRepository.save(blog);
    }

    @Transactional(readOnly = true)
    public List<Blog> getBlogList() {
        return blogRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Blog getBlog(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow();
    }

}
