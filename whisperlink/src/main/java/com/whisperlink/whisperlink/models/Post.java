package com.whisperlink.whisperlink.models;
import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;
    @ManyToOne
    @JoinColumn(name = "date_calendar_id")
    private DateCalendar date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


    // Konstruktor
    public Post(User user, String text, DateCalendar date, String time) {
        this.user = user;
        this.text = text;
        this.date = date;
        this.time = time;
    }

    //Default Constructor
    public Post() {

    }

    // Getterji in setterji



    public void setId(Long id) {
        this.id = id;
    }


    public void setText(String text) {
        this.text = this.text;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(DateCalendar date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return this.text;
    }

    public DateCalendar getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Location getLocation() {
        return location;
    }
}
