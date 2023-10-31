package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld 
{
    @GetMapping("/")
    public String print(Model model) 
    {
        model.addAttribute("message", "Hello Tamilmani, It is based on Thymeleaf.");
        return "hello"; 
    }
}

