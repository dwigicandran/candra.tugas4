
package com.example.demo.controller;

import java.util.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @GetMapping("")
    //get all data tanpa pagiination
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //get all data dengan pagination
    @GetMapping("/page")
    public ResponseEntity<Map<String ,Object>> getAllUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size )
    { return userService.getAllUsername(search,page,size); }

    //get by address type
    @GetMapping("/ByAddress")
    public List<User>getUsersByAddress(
        @RequestParam(required = false)String search,
        @RequestParam(required = false)String type )
    { return userService.getAllUserByAddress(search,type); }


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

    @PutMapping("")
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