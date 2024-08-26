package com.youlog.youlog.presentation.management;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ManageController {

    @Value("${view-name.manage-main}")
    private String manageMainView;

    @ModelAttribute
    public void addCommonAttributes(@PathVariable Long blogId, Model model) {
        model.addAttribute("blogId", blogId);
    }

    @GetMapping("${url.manage.main}")
    public String managePage(@PathVariable Long blogId) {
        return manageMainView;
    }

}
