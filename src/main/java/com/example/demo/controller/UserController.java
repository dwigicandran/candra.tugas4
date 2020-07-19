package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserService userService;


    @GetMapping("")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    @PostMapping("")
    public Map<String, Object> addNewUser(@RequestBody User dataUser) {
        
        Map<String, Object> result = new HashMap<>();

        if (userService.saveUser(dataUser)) {
            result.put("succes", true);
            result.put("message", "berhasil");
        } else {
            result.put("succes", false);
            result.put("message", "gagal");
        }
        return result;
        
        

    }
    // User insertUser(@RequestBody User dataUser){
        // User result = userService.saveUser(dataUser);
        // return result;
    // }

    
    

    @DeleteMapping("")
    Map<String,Object>deleteUser(@RequestParam int id){
        Map<String,Object> result = new HashMap<>();
        if (userService.deleteData(id)) {
            result.put("success", true);
        }else{
            result.put("success", false);
        }
        return result;
    }
    
    






}