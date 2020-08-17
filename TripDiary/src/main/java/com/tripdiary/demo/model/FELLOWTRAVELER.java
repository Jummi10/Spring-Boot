package com.tripdiary.demo.model;

import lombok.Data;

@Data
public class FELLOWTRAVELER {
    private int id;
    private int userId;
    private int postId;
    private String createdAt;
    private String updatedAt;
}
