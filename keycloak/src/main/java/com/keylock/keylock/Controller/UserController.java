package com.keylock.keylock.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    
    @GetMapping("/hello-admin")
    public String getAdmin(){
        return "This is for admin only";
    }

    @GetMapping("/hello-user")
    public String getUser(){
        return "This is for user only";
    }
}
