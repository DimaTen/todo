package com.dmitrij.javaenterprise.todo.controller;

import com.dmitrij.javaenterprise.todo.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ApplicationController {
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
    @RequestMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping("/adminView")
    public String showAllUsers() {
        return "adminView";
    }
}
