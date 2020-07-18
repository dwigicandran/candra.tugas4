package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String address,country,province;
    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id", referencedColumnName = "id")
	    private User user;



    public Address() {
    }

    public Address(int id, String address, String country, String province) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.province = province;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Address id(int id) {
        this.id = id;
        return this;
    }

    public Address address(String address) {
        this.address = address;
        return this;
    }

    public Address country(String country) {
        this.country = country;
        return this;
    }

    public Address province(String province) {
        this.province = province;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", address='" + getAddress() + "'" +
            ", country='" + getCountry() + "'" +
            ", province='" + getProvince() + "'" +
            "}";
    }
    

}