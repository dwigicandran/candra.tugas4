package com.example.demo.service;


import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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




    public ResponseEntity<Map<String, Object>> getAllUsername(String search, int page, int size) {
        try {
            List<User> users = new ArrayList<User>();
            Pageable pageable = PageRequest.of(page,size);

            Page<User> userPage;
            if (search == null) {
                userPage = repo.findAll(pageable);
            }else {
                userPage = repo.findByUsernameContaining(search, pageable);
            }
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

    public List<User>getAllUserByAddress(String search, String type) {
                switch (type) {
                    case "city":
                        return repo.findByAddress_CityContaining(search);
                    case "province":
                        return repo.findByAddress_ProvinceContaining(search);
                    case "country":
                        return repo.findByAddress_CountryContaining(search);
                    default:
                        return null;
                }
    }



}