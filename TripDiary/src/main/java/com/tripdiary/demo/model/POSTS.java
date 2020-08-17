package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class POSTS {
    private int id;
    private int planId;
    private int cityId;
    private Date travelDate;
    private String accommodation;
    private Date createdAt;
    private Date updatedAt;
}
