package org.sid.offregame.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
    @GetMapping ("/login")
    public String login(Model model){
        return "login";
    }
}
