package com.youlog.youlog.common.advice;

import com.youlog.youlog.common.properties.UrlProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ControllerAdvices {

    private static final String REDIRECT_PREFIX = "redirect:";
    private final UrlProperties urlProperties;

    @ModelAttribute
    public void addUrls(Model model) {
        model.addAttribute("urls", urlProperties);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        log.debug("MethodArgumentNotValidException: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("error", e.getAllErrors().get(0).getDefaultMessage());
        return REDIRECT_PREFIX + request.getRequestURI();
    }


}
