package com.security.secure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.security.secure.Entity.MyUser;
import com.security.secure.Service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<MyUser> createUser(@RequestBody MyUser user){
        MyUser ur=userService.createUser(user);
        return new ResponseEntity<>(ur,HttpStatus.CREATED);
    }


    
    @GetMapping("/all")
    public ResponseEntity<List<MyUser>> getAllUser(){
        
        List<MyUser> ur=userService.getAll();
        return new ResponseEntity<>(ur,HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MyUser> getUserById(@PathVariable Long id){
        MyUser user=userService.getUserById(id);
        return ResponseEntity.ok(user);

    }
}
