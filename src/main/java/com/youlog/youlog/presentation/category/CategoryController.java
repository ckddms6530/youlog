package com.youlog.youlog.presentation.category;

import com.youlog.youlog.application.category.CategoryService;
import com.youlog.youlog.presentation.category.request.CategoryCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Value("${view-name.category-manage}")
    private String categoryManageView;
    @Value("${url.manage.category}")
    private String categoryManageUrl;

    @GetMapping("${url.manage.category}")
    public String categoryManagePage(Model model, @PathVariable Long blogId) {
        model.addAttribute("blogId", blogId);
        model.addAttribute("categories", categoryService.getCategoryList(blogId));
        return categoryManageView;
    }

    @PostMapping("${url.manage.category}")
    public String createCategory(CategoryCreateRequest request) {
        categoryService.createCategory(request);
        return "redirect:" + categoryManageUrl;
    }
}
