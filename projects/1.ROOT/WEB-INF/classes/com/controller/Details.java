package com.controller;

public class Details 
{
    private String passWord;
    private String email;
    private String mobileNo;
    private String dateOfBirth;
    private String gender;
    private String location;

    public Details(String passWord, String email, String mobileNo,String dateOfBirth,String gender,String location) 
    {
        this.passWord = passWord;
        this.email = email;
        this.mobileNo = mobileNo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.location = location;
    }

    public String getPassWord() 
    { 
        return passWord;
    }

    public void setPassWord(String passWord) 
    {
        this.passWord = passWord;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getMobileNo() 
    {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) 
    {
        this.mobileNo = mobileNo;
    }
    
    public String getDateOfBirth() 
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }
}
