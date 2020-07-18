package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String username, password, name, email;
    @ElementCollection
    private List<String> role = new ArrayList<>();
    private boolean active;


    public User() {
    }

    public User(int id, String username, String password, String name, String email, List<String> role, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRole() {
        return this.role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User username(String username) {
        this.username = username;
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

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User role(List<String> role) {
        this.role = role;
        return this;
    }

    public User active(boolean active) {
        this.active = active;
        return this;
    }

   


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", role='" + getRole() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }




    
}