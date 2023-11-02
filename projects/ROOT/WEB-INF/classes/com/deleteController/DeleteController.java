package com.deleteController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.ServiceClass;
import com.controller.DisplayController;

@Controller
public class DeleteController 
{
    @Autowired
    ServiceClass service;

    @PostMapping("/deleteuser")
    public String deleteUser(
        Model model,
        @RequestParam("username")String username
    ) throws ClassNotFoundException, SQLException
    {
        Connection c = service.databaseService();
        
        String query = "DELETE FROM userdetails WHERE username = ?;";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, username);
        ps.executeUpdate();

        DisplayController.map.remove(username);
        model.addAttribute("userMap", DisplayController.map);
        ps.close();
        c.close();
        return "display";
    }
}
