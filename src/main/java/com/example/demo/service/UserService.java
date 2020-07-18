package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean deleteData(int id){
        User result = userRepository.findById(id);
        if (result != null) {
            try {
                userRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else{
            return false;
        }
    }
    
}