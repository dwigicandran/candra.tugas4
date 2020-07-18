package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String usename,password,name,role,email;
    private Boolean active;
    @OneToOne(mappedBy = "user")
	    private Address address;


    public User() {
    }

    public User(int id, String usename, String password, String name, String role, String email, Boolean active, Address address) {
        this.id = id;
        this.usename = usename;
        this.password = password;
        this.name = name;
        this.role = role;
        this.email = email;
        this.active = active;
        this.address = address;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsename() {
        return this.usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isActive() {
        return this.active;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User usename(String usename) {
        this.usename = usename;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User role(String role) {
        this.role = role;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User active(Boolean active) {
        this.active = active;
        return this;
    }

    public User address(Address address) {
        this.address = address;
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", usename='" + getUsename() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            ", email='" + getEmail() + "'" +
            ", active='" + isActive() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }


    
}