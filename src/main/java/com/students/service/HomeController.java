package com.students.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Student Base!");
        model.addAttribute("tagline", "The one and only amazing student-portal!");

        return "welcome";
    }

}