package com.richard.danis.www.sandbox.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public Model login(Model model) {
        model.addAttribute("greeting", "Richaaard");
        return model;
    }
}
