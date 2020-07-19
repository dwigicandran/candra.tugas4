package com.example.demo.service;


import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    

    @Autowired
    UserRepository repo;
    @Autowired
    AddressRepository addressRepository;


    public boolean saveUser(User dataUser) {
        User user;
        Address ud = dataUser.getAddress();
            try {
                dataUser.setAddress(null);
                user = repo.save(dataUser);
                ud.setUser(user);
                addressRepository.save(ud);
                // System.out.println("data user: " + user.toString());
                // System.out.println("data address : " + address.toString());

                return true;
            } catch (Exception e) {
                return false;
            }
    }


	public boolean hapusUser(int id) {
        User result = repo.findById(id);
        if (result != null) {
            try {
                repo.delete(result);
            return true;
            } catch (Exception e) {
                return false;
            }
            
        } else {
            return false;
        }
	}




    public boolean updateUser(User body) {
        User userResult = repo.findById(body.getId());
        if (userResult != null) {
            try {
//                userResult.setAddress(userResult.getAddress());
                repo.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
        }
        return false;
    }



}