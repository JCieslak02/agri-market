package com.jcieslak.agrimarket.payload.response;

import com.jcieslak.agrimarket.model.Image;
import lombok.Data;

@Data
public class ListingOverview {
    private String id;
    private String title;
    private Image thumbnail;
    private double price;
}

