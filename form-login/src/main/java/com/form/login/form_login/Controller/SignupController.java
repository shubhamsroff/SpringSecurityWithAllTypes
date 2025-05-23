package com.form.login.form_login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.form.login.form_login.Configuration.SecurityConfig;
import com.form.login.form_login.Entity.MyUser;
import com.form.login.form_login.Service.MyUserDetailsService;

@Controller
public class SignupController {

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new MyUser());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute MyUser user) {
        securityConfig.registerUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username+" "+password);   
        return "signup";
    }
    
}