package com.youlog.youlog.common.advice;

import com.youlog.youlog.common.error.BusinessException;
import com.youlog.youlog.common.properties.UrlProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class CommonControllerAdvice {

    private static final String REDIRECT_PREFIX = "redirect:";
    private final UrlProperties urlProperties;
    private final MessageSource messageSource;

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

    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException e, HttpServletRequest request, RedirectAttributes redirectAttributes, Locale locale) {
        log.debug("BusinessException: {}", e.getMessage());
        redirectAttributes.addFlashAttribute("error", messageSource.getMessage(e.getErrorCode().getCode(), null, locale));
        return REDIRECT_PREFIX + request.getHeader("Referer");
    }
}
