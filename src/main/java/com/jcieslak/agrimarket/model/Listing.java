package com.jcieslak.agrimarket.model;

import com.jcieslak.agrimarket.enums.ListingCategory;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "listing")
@Data
public abstract class Listing {
    @Id
    private String id;
    private String title;
    private double price;
    private String description;
    private User createdBy;
    private String contactPhone;
    private LocalDateTime createdAt;
    private ListingCategory listingCategory;
    private Image thumbnailImage;
}
