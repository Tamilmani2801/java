package com.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass 
{
    public Connection databaseService() throws SQLException
    {
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/details", "postgres", "123");
        return c;
    }   
}
