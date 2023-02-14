package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.mapper.ListingMapper;
import com.jcieslak.agrimarket.model.Listing;
import com.jcieslak.agrimarket.payload.request.ListingRequest;
import com.jcieslak.agrimarket.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    public void createListing(ListingRequest listingRequest, Principal principal){
        Listing listing = ListingMapper.MAPPER.requestToEntity(listingRequest);

        listing.setCreatedAt(LocalDateTime.now());
        listingRepository.save(listing);
    }
}
