package com.example.Gcash.App.controller;

import com.example.Gcash.App.model.Account;
import com.example.Gcash.App.operations.Create;
import com.example.Gcash.App.operations.Read;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsersController {

    private final Create registerUser = new Create();
    private final Read loginUser = new Read();

    @PostMapping("/register")
    public String register(@ModelAttribute Account account) {
        registerUser.addOperations(account);
        return "redirect:/register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String number,
                        @RequestParam String pin,
                        RedirectAttributes redirectAttrs) {

        Account account = loginUser.userLogin(number, pin);

        if (account != null) {
            redirectAttrs.addFlashAttribute("account", account);
            return "redirect:/content";
        } else {
            redirectAttrs.addFlashAttribute("error", "Invalid number or PIN");
            return "redirect:/";
        }
    }
}
