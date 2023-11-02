package com.deleteController;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.DisplayService;

@Controller
public class DeleteController 
{
    @Autowired
    DisplayService service;

    @PostMapping("/deleteuser")
    public String deleteUser(
        Model model,
        @RequestParam("username")String username
    ) throws SQLException 
    {
        service.delete(username);
        model.addAttribute("userMap", service.display());
        return "display";
    }
}
