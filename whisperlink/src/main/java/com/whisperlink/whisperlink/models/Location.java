package com.whisperlink.whisperlink.models;
import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String city;
    private String country;

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getCountry() {return country;}
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
