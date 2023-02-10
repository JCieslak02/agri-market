package com.jcieslak.agrimarket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "listing")
@Data
public class Listing {
    @Id
    private String id;
    private String title;
    private double price;
    private String description;
    private User createdBy;
    private LocalDateTime createdAt;
}
