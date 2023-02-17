package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.exception.EntityNotFoundException;
import com.jcieslak.agrimarket.mapper.ListingMapper;
import com.jcieslak.agrimarket.model.Listing;
import com.jcieslak.agrimarket.payload.request.CreateListingRequest;
import com.jcieslak.agrimarket.payload.response.ListingResponse;
import com.jcieslak.agrimarket.repository.ListingRepository;
import com.jcieslak.agrimarket.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final SecurityUtils securityUtils;

    public void createListing(CreateListingRequest createListingRequest){
        Listing listing = ListingMapper.MAPPER.requestToEntity(createListingRequest);

        listing.setCreatedAt(LocalDateTime.now());
        listing.setCreatedBy(securityUtils.getCurrentUser());
        listingRepository.save(listing);
    }

    // 2 methods below are for simplicity’s sake - first one for controller, the latter for internal service use
    public ListingResponse findListingResponseById(String listingId){
        return ListingMapper.MAPPER.entityToResponse(findListingById(listingId));
    }

    private Listing findListingById(String listingId){
        return listingRepository.findById(listingId)
                .orElseThrow(() -> new EntityNotFoundException("Listing", listingId));
    }
}
