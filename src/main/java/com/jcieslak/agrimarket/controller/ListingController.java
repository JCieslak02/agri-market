package com.jcieslak.agrimarket.controller;

import com.jcieslak.agrimarket.payload.request.ListingRequest;
import com.jcieslak.agrimarket.repository.ListingRepository;
import com.jcieslak.agrimarket.service.ListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
public class ListingController {
    private final ListingRepository listingRepository;
    private final ListingService listingService;
    @PostMapping
    public void createListing(@RequestBody @Valid ListingRequest listingRequest, Principal principal){
        listingService.createListing(listingRequest, principal);
    }
}
