package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {
    
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;

    @GetMapping("")
    List<Address> getAllAddres(){
        return addressRepository.findAll();
    }

    @PostMapping("")
    public Map<String, Object> addNewAddress(@RequestBody Address dataAddress) {
        
        Map<String, Object> result = new HashMap<>();

        if (addressService.saveAddress(dataAddress)) {
            result.put("succes", true);
            result.put("message", "berhasil");
        } else {
            result.put("succes", false);
            result.put("message", "gagal");
        }
        return result;
    }

    @PutMapping("")
    Map<String,Object>updateAddresses(@RequestBody Address body){
        System.out.println("body : " + body.toString());
        Map<String,Object> result = new HashMap<>();

        if (addressService.updateAddress(body)) {
            result.put("success", true);
            result.put("message", "User Updated!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Updated!");
        }
        return result;
    }

    @DeleteMapping("")
        //id dr param postman
    Map<String,Object>deleteUser(@RequestParam int id){
        Map<String,Object> result = new HashMap<>();
        if (addressService.hapusAddress(id)) {
            result.put("success", true);
            result.put("message", "User Deleted!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        } return result;
    }

    @GetMapping("/byId")
    Map<String,Object> getAddressById(@RequestParam int userId){
        return addressService.getAddressById(userId);
    }

    @GetMapping("/byType")
    public List<Address>getAddresssByType(
            @RequestParam(required = false)String search,
            @RequestParam(required = false)String type )
    { return addressService.getAllAddressByType(search,type); }





    
}