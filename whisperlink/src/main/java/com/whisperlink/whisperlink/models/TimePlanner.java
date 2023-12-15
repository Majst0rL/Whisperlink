package com.whisperlink.whisperlink.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class TimePlanner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateTime;
    private String location;
    private String name;

    // Konstruktorji
    public TimePlanner() {
        // Privzeti prazen konstruktor
    }

    public TimePlanner(Date dateTime, String location, String name) {
        this.dateTime = dateTime;
        this.location = location;
        this.name = name;
    }

    // Getterji in setterji
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Dodatne metode
    @Override
    public String toString() {
        return "TimePlanner{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePlanner that = (TimePlanner) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(location, that.location) &&
                Objects.equals(name, that.name);
    }


}
