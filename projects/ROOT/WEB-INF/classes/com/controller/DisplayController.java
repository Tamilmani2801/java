package com.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.DisplayService;

@Controller
public class DisplayController 
{   
    @Autowired
    DisplayService service;

    @GetMapping("/")
    public String allUsers(Model model) throws SQLException 
    { 
        model.addAttribute("userMap", service.display());
        return "display";
    }

    @PostMapping("/addusers")
    public String addUsers(Model model)
    {
        return "SignUp";
    }  
    
    @PostMapping("/getDetails")
    public String getDetails(
        Model model,
        @RequestParam("username")String username,
        @RequestParam("password")String password,
        @RequestParam("email")String email,
        @RequestParam("mobileno")String mobileNo,
        @RequestParam("dob")String dateOfBirth,
        @RequestParam("gender")String gender,
        @RequestParam("location")String location
    ) throws SQLException{
        if(service.display().containsKey(username))
        {
            model.addAttribute("message", "Username Already Used");
            return "SignUp";
        }
        else
        {
            service.add(username, password, email, mobileNo, dateOfBirth, gender, location);
            model.addAttribute("userMap", service.display());
            return "display";
        }
    }
}
