package com.example.accessmanagementsystem.conteroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoorController {

    private int clickCount = 0;

    @GetMapping("/")
    public String showPage(Model model) {
        model.addAttribute("clickCount", clickCount);
        return "index";
    }

    @PostMapping("/increment")
    public String incrementCounter(Model model) {
        clickCount++;
        model.addAttribute("clickCount", clickCount);
        return "index";
    }
}
