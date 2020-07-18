package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;


    @GetMapping("api/user")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("api/user/insert")
    User insertUser(@RequestBody User dataUser){
        User result = userRepository.save(dataUser);
        return result;
    }
    






}