package com.example.u_pay.controller;

import com.example.u_pay.model.Account;
import com.example.u_pay.model.ViewTransaction;
import com.example.u_pay.repository.TransactionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GetMappingController {

    @Autowired
    private Account account;

    @Autowired
    private TransactionRepository transactionRepository;


    // Login page
    @GetMapping("/")
    public String getLoginHtml() {
        return "login"; // login.html
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            return "redirect:/home";
        }

        String idToSearch = account.getAccountNumber();

        List<ViewTransaction> logs = transactionRepository.findByAccountId(idToSearch);

        model.addAttribute("account", account);
        model.addAttribute("logs", logs);

        return "home";
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
