package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class COUNTRIES {
    private int id;
    private String countryName;
    private int continentId;
    private Date createdAt;
    private Date updatedAt;
}
