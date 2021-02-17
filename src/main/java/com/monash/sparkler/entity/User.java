package com.monash.sparkler.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
             name = "user_sequence",
             sequenceName = "user_sequence",
             allocationSize = 1
    )
    @GeneratedValue(

            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long u_id;
    private String userName;
    private String password;
    private LocalDate dob;
    private String email;
    private String phoneNumber;


    //default constructor
    public User() {
    }

    //constructor
    public User(Long u_id, String userName, String password, LocalDate dob, String email, String phoneNumber) {

        this.u_id = u_id;
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //getter methods
    public Long getU_id() {
        return u_id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setter methods
    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //to String


    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
