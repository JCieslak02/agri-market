package com.jcieslak.agrimarket.payload.response;

import com.jcieslak.agrimarket.enums.ListingCategory;
import com.jcieslak.agrimarket.model.Image;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public abstract class ListingResponse {
    private String id;
    private String title;
    private double price;
    private String description;
    private UserResponse createdBy;
    private String contactPhone;
    private LocalDateTime createdAt;
    private ListingCategory listingCategory;
    private List<Image> images;
    private Image thumbnail;
}
