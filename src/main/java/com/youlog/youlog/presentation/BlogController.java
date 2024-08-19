package com.youlog.youlog.presentation;

import com.youlog.youlog.application.BlogService;
import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.member.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private static final String BLOG_HOME_VIEW = "blog/blog_home";
    private static final String BLOG_CREATE_VIEW = "blog/blog_create";

    private final BlogService blogService;

    @GetMapping("${url.blog.create}")
    public String createForm() {
        return BLOG_CREATE_VIEW;
    }

    @PostMapping("${url.blog.create}")
    public String create(String name, @AuthenticationPrincipal CustomUserDetails userDetails) {
        blogService.register(name, userDetails.getId());
        return "redirect:/blogs";
    }

    @GetMapping("${url.blog.home}")
    public String blogHome(Model model) {
        List<Blog> blogList = blogService.getBlogList();
        model.addAttribute("blogList", blogList);
        return BLOG_HOME_VIEW;
    }

    @GetMapping("${url.blog.view}")
    public String viewBlog(@PathVariable Long blogId, Model model) {
        Blog blog = blogService.getBlog(blogId);
        model.addAttribute("blog", blog);
        return "blog/blog";
    }

}
