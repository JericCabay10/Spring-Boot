package com.example.Gcash.App;

import com.example.Gcash.App.database.Database;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String databaseController() {

        Database conn = new Database();

        if(Database.getConenction() != null) {
            System.out.println("Connection successfull");
        }else {
            System.out.println("Connection Failed");
        }

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String gotoRegister() {
        return "register";
    }

    @GetMapping("/content")
    public String gotoContent(Model model) {
        return "content";
    }
    
    /// /////////////////////////////////////////////
    @GetMapping("/setting")
    public String getContent() {
        return "settings";
    }

}