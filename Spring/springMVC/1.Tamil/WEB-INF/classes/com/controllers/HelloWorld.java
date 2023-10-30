package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class HelloWorld 
{
    @RequestMapping("/")
    public String print()
    {
      return "Hello Tamilmani,... It is based on xml without thymelead for return we use directly @ResponseBody";
    }
}
