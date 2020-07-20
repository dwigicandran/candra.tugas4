package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public boolean updateAddress(Address body) {
        Address userResult = addressRepository.findById(body.getId());
        if (userResult != null) {
            try {
//                userResult.setAddress(userResult.getAddress());
                addressRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
        }
        return false;
    }

    public boolean hapusAddress(int id) {
        Address result = addressRepository.findById(id);
        if (result != null) {
            try {
                addressRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }

    public Map<String, Object> getAddressById(int userId) {
        Address result = addressRepository.findById(userId);
        Map<String, Object> resultMap = new HashMap<>();
        if (result != null) {
            resultMap.put("success", true);
            resultMap.put("record", result);
        } else {
            resultMap.put("success", false);
            resultMap.put("message", "data address tidak di temukan");
        }
        return resultMap;
    }

    public List<Address> getAllAddressByType(String search, String type) {
        switch (type) {
            case "city":
                return addressRepository.findByCityContaining(search);
            case "province":
                return addressRepository.findByCountryContaining(search);
            case "country":
                return addressRepository.findByProvinceContaining(search);
            default:
                return null;
        }
    }







}