package com.tripdiary.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.zip.DataFormatException;

@Data
public class BODY {
    private int id;
    private int postId;
    private String contents;
    private Date createdAt;
    private Date updatedAt;
}
