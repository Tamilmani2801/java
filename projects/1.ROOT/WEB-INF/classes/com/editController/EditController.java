package com.editController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.ServiceClass;
import com.controller.Details;
import com.controller.DisplayController;

@Controller
public class EditController 
{
    @Autowired
    ServiceClass service;

    @PostMapping("/edituser")
    public String editUser(Model model, @RequestParam("username") String username) 
    {
        Details user = DisplayController.map.get(username);
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
        Connection c = service.databaseService();

        String updatedata = "UPDATE userdetails SET password=?, email=?, mobileNo=?, dateOfBirth=?, gender=?, location=? WHERE username=?";
        PreparedStatement ps = c.prepareStatement(updatedata);

        ps.setString(1,password);
        ps.setString(2,email);
        ps.setString(3,mobileNo);
        ps.setString(4,dateOfBirth);
        ps.setString(5,gender);
        ps.setString(6,location);
        ps.setString(7,username);
        ps.executeUpdate();

        Details detail = new Details(password, email,mobileNo,dateOfBirth,gender,location);
        DisplayController.map.put(username,detail);
        model.addAttribute("userMap", DisplayController.map);
        return "display";
    }

    @PostMapping("/canceledit")
    public String canceledit(Model model)
    {
        model.addAttribute("userMap", DisplayController.map);
        return "display";
    }
}

