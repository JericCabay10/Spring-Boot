package com.example.u_pay.controller;

import com.example.u_pay.model.Account;
import com.example.u_pay.model.Money;
import com.example.u_pay.operations.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostMappingController {

    private final Create add = new Create();

    // Registration
    @PostMapping("/register")
    public String postRegister(@ModelAttribute Account account, RedirectAttributes redirectAttrs) {
        add.register(account);
        redirectAttrs.addFlashAttribute("message", "Account registered successfully!");
        return "redirect:/register";
    }

    // Login
    @PostMapping("/login")
    public String postLogin(@RequestParam String number,
                            @RequestParam int pin,
                            HttpSession session,
                            RedirectAttributes redirectAttrs) {

        boolean success = Read.validatePin(number, pin);

        if (success) {
            // Fetch full account from DB
            Account account = View.getAccount(number, pin);
            session.setAttribute("account", account); // store in session
            return "redirect:/home";
        } else {
            redirectAttrs.addFlashAttribute("error", "Invalid number or PIN");
            return "redirect:/";
        }
    }

    // Change PIN
    @PostMapping("/reset-password")
    public String postChangePin(@RequestParam int oldPin,
                                @RequestParam int newPin,
                                @RequestParam int confirmPin,
                                HttpSession session,
                                RedirectAttributes redirectAttrs) {

        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            redirectAttrs.addFlashAttribute("error", "You must be logged in to change your PIN.");
            return "redirect:/";
        }

        String number = account.getAccountNumber();

        if (!Read.validatePin(number, oldPin)) {
            redirectAttrs.addFlashAttribute("error", "Old PIN is incorrect!");
            return "redirect:/settings";
        }

        if (newPin != confirmPin) {
            redirectAttrs.addFlashAttribute("error", "New PIN and confirmation PIN do not match!");
            return "redirect:/settings";
        }

        boolean success = Update.changePin(number, newPin);
        if (success) {
            // Update session account PIN
            account.setAccountPin(newPin);
            session.setAttribute("account", account);

            redirectAttrs.addFlashAttribute("message", "PIN updated successfully!");
        } else {
            redirectAttrs.addFlashAttribute("error", "Failed to update PIN. Try again.");
        }

        return "redirect:/settings";
    }

    @PostMapping("/cash-in")
    public String cashInMoney(@RequestParam("amount") double amount,
                              HttpSession session,
                              RedirectAttributes redirectAttrs) {

        // Get logged-in account
        Money account = (Money) session.getAttribute("account");
        if (account == null) {
            redirectAttrs.addFlashAttribute("error", "You must login first!");
            return "redirect:/";
        }

        if (amount <= 0) {
            redirectAttrs.addFlashAttribute("error", "Amount must be greater than 0!");
            return "redirect:/home";
        }

        boolean success = Transaction.cashIn(account.getAccountNumber(), amount);

        if (success) {
            // Update session with new savings
            account.setSavingAccount(account.getSavingAccount() + amount);
            session.setAttribute("account", account);

            redirectAttrs.addFlashAttribute("success", "Cash in successful! Amount added: " + amount);
        } else {
            redirectAttrs.addFlashAttribute("error", "Failed to cash in. Try again.");
        }

        return "redirect:/home";
    }

}
