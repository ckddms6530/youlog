package com.youlog.youlog.presentation;

import com.youlog.youlog.application.MemberService;
import com.youlog.youlog.presentation.request.MemberRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        log.debug("login page request");
        if (error != null) {
            log.debug("login failed");
            model.addAttribute("error", "이메일과 비밀번호를 확인해주세요.");
        }
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid MemberRegisterRequest registerRequest) {
        memberService.registerMember(registerRequest.email(), registerRequest.password(), registerRequest.nickname());
        return "redirect:/";
    }
}
