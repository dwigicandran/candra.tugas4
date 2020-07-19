
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
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


    @DeleteMapping("")
    //id dr param postman
    Map<String,Object>deleteUser(@RequestParam int id){
        Map<String,Object> result = new HashMap<>();
        if (userService.hapusUser(id)) {
            result.put("success", true);
            result.put("message", "User Deleted!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        } return result;
    }

    @PutMapping("update")
    Map<String,Object>updateUsers(@RequestBody User body){
        System.out.println("body : " + body.toString());
        Map<String,Object> result = new HashMap<>();

        if (userService.updateUser(body)) {
            result.put("success", true);
            result.put("message", "User Updated!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Updated!");
        }
        return result;
    }

    
    






}