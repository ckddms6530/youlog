package com.youlog.youlog.common.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@Slf4j
public class ControllerAdvices {

    private static final String REDIRECT_PREFIX = "redirect:";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        log.debug("MethodArgumentNotValidException: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("error", e.getAllErrors().get(0).getDefaultMessage());
        return REDIRECT_PREFIX + request.getRequestURI();
    }
}
