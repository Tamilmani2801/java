package com.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {
    @GetMapping("/")
    public String view(Model model) {
        try (Connection c = createDB(); Statement s = c.createStatement()) 
        {
           
            String createTable = "CREATE TABLE IF NOT EXISTS userdetails(id int, name varchar(20));";
            s.executeUpdate(createTable);
            
            int id = 1;
            String name = "naveen";

            String insertData = "INSERT INTO userdetails(id, name) VALUES(?, ?)";
            PreparedStatement ps = c.prepareStatement(insertData);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();

            ArrayList<users> list = new ArrayList<>();
            ResultSet rs = s.executeQuery("SELECT * FROM userdetails;");
            while (rs.next()) 
            {
                id = rs.getInt("id");
                name = rs.getString("name");
                list.add(new users(id, name));
            }
            model.addAttribute("list", list);
            return "view";
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("message", "An error occurred: " + e.getMessage());
            return "hello";
        }
    }

    private Connection createDB() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/details", "postgres", "123");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}
