package com.DevCraftLab.QuickMail.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @RequestMapping("/hello")
    public String HelloWorld(){
        return "Hello World";
    }
}
