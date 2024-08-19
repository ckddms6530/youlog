package com.youlog.youlog.presentation;

import com.youlog.youlog.application.PostService;
import com.youlog.youlog.domain.member.CustomUserDetails;
import com.youlog.youlog.presentation.request.PostWriteRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping("${url.post.write}")
    public String writePostPage() {
        return "post/post_write";
    }

    @PostMapping("${url.post.write}")
    public String writePost(@Valid PostWriteRequest request, @AuthenticationPrincipal CustomUserDetails userDetails) {
        log.info("writePost request: {}", userDetails.getNickname());
        postService.writePost(request, userDetails.getId());
        return "redirect:/blogs";
    }

    @GetMapping("${url.post.view}")
    public String getPostPage() {
        return "post";
    }

}
