package com.whisperlink.whisperlink.models;
import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String postalCode;
    private String city;
    private String country;

    //Constructor
    public Location(String address, String city, String country, String postalCode) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    //Default constructor
    public Location() {

    }

    public Location(String postalCode) {
        this.postalCode = postalCode;
    }
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

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
