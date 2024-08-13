package com.youlog.youlog.presentation;

import com.youlog.youlog.application.BlogService;
import com.youlog.youlog.domain.blog.Blog;
import com.youlog.youlog.domain.member.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    @GetMapping("/register")
    @PreAuthorize("hasRole('MEMBER')")
    public String registerForm() {
        return "register_blog";
    }

    @PostMapping
    @PreAuthorize("hasRole('MEMBER')")
    public String register(String name, @AuthenticationPrincipal CustomUserDetails userDetails) {
        blogService.register(name, userDetails.getId());
        return "redirect:/blog/" + name;
    }

    @GetMapping("/home")
    public String blogHome(Model model) {
        List<Blog> blogList = blogService.getBlogList();
        model.addAttribute("blogList", blogList);
        return "blog_home";
    }
    @GetMapping("/{blogId}")
    public String blogDetail(@PathVariable Long blogId, Model model) {
        Blog blog = blogService.getBlog(blogId);
        model.addAttribute("blog", blog);
        return "blog";
    }
}
