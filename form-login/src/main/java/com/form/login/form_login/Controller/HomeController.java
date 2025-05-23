package com.form.login.form_login.Controller;
import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.form.login.form_login.Entity.MyUser;
import com.form.login.form_login.Repository.MyUserRepository;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @Autowired
    private MyUserRepository userRepository;
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }
   
    @GetMapping("/examp")
    @ResponseBody
    public List<MyUser> getMethodName() throws InterruptedException {
        Thread.currentThread().sleep(4000);
        return userRepository.findAll();
    }
    
}