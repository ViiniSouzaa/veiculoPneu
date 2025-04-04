package com.project.veiculoPneu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";  // ou algum nome de view ou página que você tenha
    }
}
