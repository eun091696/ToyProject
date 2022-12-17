package com.ToyProject.eun.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model, @RequestParam @Nullable String username) {
            String uri = request.getHeader("Referer");
            if(uri != null && !uri.contains("/login") && !uri.contains("register")) {
            request.getSession().setAttribute("prevPage", uri);
        }
        model.addAttribute("username", username == null ? "" : username);
        return "login";
    }
}
