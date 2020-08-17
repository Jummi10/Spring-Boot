package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class CITIES {
    private int id;
    private String cityName;
    private int countryId;
    private Date createdAt;
    private Date updatedAt;
}
