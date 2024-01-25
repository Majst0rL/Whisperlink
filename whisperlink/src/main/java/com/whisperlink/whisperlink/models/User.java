package com.whisperlink.whisperlink.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Date;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "date_calendar_id", referencedColumnName = "id")
    private DateCalendar birthDate;
    private Gender gender; //MALE,FEMALE
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;  // ADMIN, USER, MODERATOR

    @ManyToMany(mappedBy = "users")
    private List<Organization> organizations;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public User(String firstName, String lastName, String username, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {

    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public DateCalendar getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthDate(DateCalendar birthDate) {
        this.birthDate = birthDate;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}