package com.youlog.youlog.presentation.member;

import com.youlog.youlog.application.MemberService;
import com.youlog.youlog.presentation.member.request.MemberRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private static final String LOGIN_VIEW = "member/login";
    private static final String SIGNUP_VIEW = "member/signup";

    private final MemberService memberService;

    @GetMapping("${url.login}")
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            log.debug("login failed");
            model.addAttribute("error", "이메일과 비밀번호를 확인해주세요.");
        }
        return LOGIN_VIEW;
    }

    @GetMapping("${url.signup}")
    @PreAuthorize("isAnonymous()")
    public String registerPage() {
        return SIGNUP_VIEW;
    }

    @PostMapping("${url.signup}")
    public String register(@Valid MemberRegisterRequest registerRequest) {
        memberService.registerMember(registerRequest.email(), registerRequest.password(), registerRequest.nickname());
        return "redirect:/";
    }
}
