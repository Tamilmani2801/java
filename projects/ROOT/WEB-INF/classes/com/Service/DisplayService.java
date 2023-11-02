package com.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.Details;

@Service
public class DisplayService 
{
    public static Map<String,Details> map = new TreeMap<>();
    
    @Autowired
    DBConnectionService dbService;

    public Map<String,Details> display() throws SQLException
    {
        Connection c = dbService.databaseService();
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
        return map;
    }

    public void add(String username,String password,String email,String mobileNo,String dateOfBirth,String gender,String location) throws SQLException
    {
        Connection c = dbService.databaseService();
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
    }

    public void delete(String username) throws SQLException
    {
        Connection c = dbService.databaseService();
        
        String query = "DELETE FROM userdetails WHERE username = ?;";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, username);
        ps.executeUpdate();

        map.remove(username);
    }

    public void edit(String username, String password, String email, String mobileNo, String dateOfBirth, String gender, String location) throws SQLException
    {
        Connection c = dbService.databaseService();

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
        DisplayService.map.put(username,detail);
    }
}