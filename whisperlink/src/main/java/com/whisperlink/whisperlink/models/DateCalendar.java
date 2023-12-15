package com.whisperlink.whisperlink.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class DateCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int day;
    private int month;
    private int year;

    // Konstruktorji
    public DateCalendar() {
        // Privzeti prazen konstruktor
    }

    public DateCalendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    // Getterji in setterji
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Dodatne metode
    @Override
    public String toString() {
        return "DateCalendar{" +
                "id=" + id +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateCalendar that = (DateCalendar) o;
        return day == that.day &&
                month == that.month &&
                year == that.year &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, month, year);
    }

    // Dodajte druge metode glede na vaše potrebe
}
