package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}