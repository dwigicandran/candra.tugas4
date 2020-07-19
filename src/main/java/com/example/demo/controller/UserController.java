
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
//    List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
    //get all data dengan pagination
    public ResponseEntity<Map<String ,Object>> getAllUsers(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        try {
            List<User> users = new ArrayList<User>();
            Pageable pageable = PageRequest.of(page,size);

            Page<User> userPage;
            if (username == null)
                userPage = userRepository.findAll(pageable);
             else
                userPage = userRepository.findByUsernameContaining(username, pageable);
            users = userPage.getContent();

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("users", users);
            response.put("currentPage", userPage.getNumber());
            response.put("totalItems", userPage.getTotalElements());
            response.put("totalPages", userPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
                return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            }
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