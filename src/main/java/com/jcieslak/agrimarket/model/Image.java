package com.jcieslak.agrimarket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "image")
public class Image{
    @Id
    private String id;
    private String fileName;
    private long size;
    private byte[] imageData;
    private Listing listing;
}
