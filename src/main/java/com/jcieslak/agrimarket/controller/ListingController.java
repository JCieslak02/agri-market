package com.jcieslak.agrimarket.controller;

import com.jcieslak.agrimarket.payload.request.CreateListingRequest;
import com.jcieslak.agrimarket.payload.response.ListingOverview;
import com.jcieslak.agrimarket.payload.response.ListingResponse;
import com.jcieslak.agrimarket.service.ListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;
    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Void> createListing(@RequestBody @Valid CreateListingRequest createListingRequest){
        listingService.createListing(createListingRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{listingId}")
    public ResponseEntity<ListingResponse> findListingById(@PathVariable String listingId){
        ListingResponse listingResponse = listingService.getListingResponseById(listingId);
        return ResponseEntity.ok(listingResponse);
    }

    @PostMapping("/{listingId}/images")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<Void> addImagesToListing(@PathVariable String listingId, @RequestParam List<MultipartFile> images){
        listingService.addImagesToListing(listingId, images);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dupa/{listingId}")
    public ListingOverview findListingByIddd(@PathVariable String listingId){
        return listingService.getListingOverviewByListingId(listingId);
    }
}
