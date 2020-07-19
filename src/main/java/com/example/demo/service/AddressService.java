package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    AddressRepository addressRepository;

    public boolean saveAddress(Address dataAddress) {
            try {
                addressRepository.save(dataAddress);
                // System.out.println("data user: " + user.toString());
                // System.out.println("data address : " + address.toString());

                return true;
            } catch (Exception e) {
                return false;
            }
    }





    
}