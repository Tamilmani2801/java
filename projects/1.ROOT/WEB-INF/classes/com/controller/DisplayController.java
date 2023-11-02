package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Service.ServiceClass;

@Controller
public class DisplayController 
{
    public static Map<String,Details> map = new TreeMap<>();
    
    @Autowired
    ServiceClass service;

    @GetMapping("/")
    public String allUsers(Model model) throws ClassNotFoundException, SQLException
    {
        Connection c = service.databaseService();
        Statement s = c.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM userdetails;");
        while (rs.next()) 
        {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String mobileNo = rs.getString("mobileNo");
            String dateOfBirth = rs.getString("DateOfBirth");
            String gender = rs.getString("gender");
            String location = rs.getString("location");
            Details detail = new Details(password, email,mobileNo,dateOfBirth,gender,location);
            map.put(username,detail);
        }
        model.addAttribute("userMap", map);
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
    ) throws ClassNotFoundException, SQLException {
        if(map.containsKey(username))
        {
            model.addAttribute("message", "Username Already Used");
            return "SignUp";
        }
        else
        {
            Connection c = service.databaseService();
            Statement s = c.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS userdetails("
                                        + "username varchar(30),"
                                        + "password varchar(10),"
                                        + "email varchar(20),"
                                        + "mobileno varchar(10),"
                                        + "dateOfBirth varchar(10),"
                                        + "gender varchar(5),"
                                        + "location varchar(30));";
            s.executeUpdate(createTable);

            String insertData = "INSERT INTO userdetails(username,password,email,mobileNo,dateOfBirth,gender,location) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(insertData);

            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,mobileNo);
            ps.setString(5,dateOfBirth);
            ps.setString(6,gender);
            ps.setString(7,location);
            ps.executeUpdate();

            ResultSet rs = s.executeQuery("SELECT * FROM userdetails ORDER BY username;");
            while (rs.next()) 
            {
                username = rs.getString("username");
                password = rs.getString("password");
                email = rs.getString("email");
                mobileNo = rs.getString("mobileNo");
                dateOfBirth = rs.getString("DateOfBirth");
                gender = rs.getString("gender");
                location = rs.getString("location");
                Details detail = new Details(password, email,mobileNo,dateOfBirth,gender,location);
                map.put(username,detail);
            }
            model.addAttribute("userMap", map);
            return "display";
        }
    }
}
