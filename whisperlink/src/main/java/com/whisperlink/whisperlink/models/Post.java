package com.whisperlink.whisperlink.models;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private String user;
    private String text;
    private Date date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
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

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Location getLocation() {
        return location;
    }
}
