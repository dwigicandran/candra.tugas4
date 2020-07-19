package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

	User findById(int id);
	Page<User> findByUsernameContaining(String search,Pageable pageable);
	List<User> findByAddress_CityContaining(String search);
	List<User> findByAddress_ProvinceContaining(String search);
	List<User> findByAddress_CountryContaining(String search);


}