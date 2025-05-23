package com.oauth2.secure_oauth2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/hello")
    public String getHello(){
        return "Now You are logged with google";
    }
}
