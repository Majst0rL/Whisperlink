package com.whisperlink.whisperlink.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class TimePlanner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "date_calendar_id")
    private DateCalendar date;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private String name;

    // Konstruktorji
    public TimePlanner() {
        // Privzeti prazen konstruktor
    }

    public TimePlanner(DateCalendar date, Location location, String name) {
        this.date = date;
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

    public DateCalendar getDateTime() {
        return date;
    }

    public void setDateTime(DateCalendar date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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
                ", dateTime=" + date +
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
                Objects.equals(date, that.date) &&
                Objects.equals(location, that.location) &&
                Objects.equals(name, that.name);
    }


}
