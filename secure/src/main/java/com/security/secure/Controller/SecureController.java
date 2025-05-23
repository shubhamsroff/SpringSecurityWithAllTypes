package com.security.secure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/user")
    public String getUser(){
        return "This is Specially for User";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "This is Specially for Admin";
    }
}
