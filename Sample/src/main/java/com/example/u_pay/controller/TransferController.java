package com.example.bank.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransferController {

    private final AccountService service;

    public TransferController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/transfer")
    public String transferPage() {
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transferMoney(
            @RequestParam String toNumber,
            @RequestParam double amount,
            HttpSession session) {

        Account user = (Account) session.getAttribute("user");

        boolean success = service.transfer(
                user.getNumber(),
                toNumber,
                amount);

        if (!success) {
            return "redirect:/transfer?error=true";
        }

        return "redirect:/transfer?success=true";
    }
}
