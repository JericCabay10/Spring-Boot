package com.example.u_pay.controller;

import com.example.u_pay.model.Account;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetMappingController {

    // Login page
    @GetMapping("/")
    public String getLoginHtml() {
        return "login"; // login.html
    }

    // Home/dashboard page
    @GetMapping("/home")
    public String getHomeHtml(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            model.addAttribute("account", account);
            return "home";
        } else {
            return "redirect:/"; // redirect to login if not logged in
        }
    }

    // Register page
    @GetMapping("/register")
    public String getRegisterHtml(Model model) {
        model.addAttribute("account", new Account());
        return "register";
    }

    // Settings page
    @GetMapping("/settings")
    public String getSettingsHtml(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            model.addAttribute("account", account);
            return "settings";
        } else {
            return "redirect:/";
        }
    }

    // Change PIN page
    @GetMapping("/reset-password")
    public String getNewPinHtml(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            model.addAttribute("account", account);
            return "changePin";
        } else {
            return "redirect:/";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; // back to login
    }
}
