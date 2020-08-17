package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class USERS {
    private int id;
    private String account;
    private String password;
    private String userName;
    private int age;
    private char gender;
    private int nationality;
    private Date birthday;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
