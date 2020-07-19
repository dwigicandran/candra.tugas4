package com.example.demo.service;


import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;


    public boolean saveUser(User dataUser) {
        User user;
        // Address address;
        Address ud = dataUser.getAddress();
            try {
                dataUser.setAddress(null);
                user = userRepository.save(dataUser);
                //ud.setId(user.getId());
                ud.setUser(user);

                //address = 
                addressRepository.save(ud);
                // System.out.println("data user: " + user.toString());
                // System.out.println("data address : " + address.toString());

                return true;
            } catch (Exception e) {
                return false;
            }
    }

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