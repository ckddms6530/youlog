package com.youlog.youlog.presentation;

import com.youlog.youlog.application.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs/{blogId}/manage")
@RequiredArgsConstructor
public class BlogManageController {

    private final BlogService blogService;

    @GetMapping
    public String blogManagePage(@PathVariable Long blogId) {
        return "blog_manage";
    }
}
