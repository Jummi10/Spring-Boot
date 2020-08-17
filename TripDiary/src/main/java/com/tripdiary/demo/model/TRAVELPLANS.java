package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class TRAVELPLANS {
    private int id;
    private int countryId;
    private int userId;
    private Date dapartureDate;
    private Date returnDate;
    private String createdAt;
    private String updatedAt;
}
