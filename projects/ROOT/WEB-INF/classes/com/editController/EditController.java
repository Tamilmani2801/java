package com.editController;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.DisplayService;
import com.controller.Details;

@Controller
public class EditController 
{
    @Autowired
    DisplayService service;

    @PostMapping("/edituser")
    public String editUser(Model model, @RequestParam("username") String username) 
    {
        Details user = DisplayService.map.get(username);

        model.addAttribute("username",username);
        model.addAttribute("password", user.getPassWord()); 
        model.addAttribute("email", user.getEmail());
        model.addAttribute("mobileno", user.getMobileNo());
        model.addAttribute("dob", user.getDateOfBirth());
        model.addAttribute("gender", user.getGender());
        model.addAttribute("location", user.getLocation());
        return "editDetails";
    }

    @PostMapping("/getEditDetails")
    public String saveEditedDetails(
        Model model, 
        @RequestParam("username") String username, 
        @RequestParam("password") String password, 
        @RequestParam("email") String email, 
        @RequestParam("mobileno") String mobileNo,        
        @RequestParam("dob")String dateOfBirth,
        @RequestParam("gender")String gender,
        @RequestParam("location")String location
    ) throws ClassNotFoundException, SQLException {
        service.edit(username,password,email,mobileNo,dateOfBirth,gender,location);
        model.addAttribute("userMap", DisplayService.map);
        return "display";
    }

    @PostMapping("/canceledit")
    public String canceledit(Model model)
    {
        model.addAttribute("userMap", DisplayService.map);
        return "display";
    }
}

