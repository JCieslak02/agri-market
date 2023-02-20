package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.exception.EntityNotFoundException;
import com.jcieslak.agrimarket.mapper.ListingMapper;
import com.jcieslak.agrimarket.model.Image;
import com.jcieslak.agrimarket.model.Listing;
import com.jcieslak.agrimarket.payload.request.CreateListingRequest;
import com.jcieslak.agrimarket.payload.response.ListingResponse;
import com.jcieslak.agrimarket.repository.ImageRepository;
import com.jcieslak.agrimarket.repository.ListingRepository;
import com.jcieslak.agrimarket.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final SecurityUtils securityUtils;
    private final ImageRepository imageRepository;
    public static final int MAX_IMAGES_PER_LISTING = 10;
    private static final List<String> ALLOWED_IMAGE_EXTENSIONS = List.of("jpg", "jpeg", "png");

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

    public void addImagesToListing(String listingId, List<MultipartFile> images){
        Listing listing = findListingById(listingId);
        int listingImagesCount = imageRepository.countAllByListing(listing);
        int imagesCountWithNewlyAdded = listingImagesCount + images.size();

        if(imagesCountWithNewlyAdded > MAX_IMAGES_PER_LISTING) throw new IllegalArgumentException("Max listing images count is: " + MAX_IMAGES_PER_LISTING);

        images.forEach(image -> {
            String extension = FilenameUtils.getExtension(image.getOriginalFilename());
            if (!ALLOWED_IMAGE_EXTENSIONS.contains(extension)) {
                throw new IllegalArgumentException("Allowed image extensions are: " + ALLOWED_IMAGE_EXTENSIONS + " You provided: " + extension);
            }

            try (InputStream inputStream = image.getInputStream()){
                Image dbImage = new Image();
                dbImage.setImageData(inputStream.readAllBytes());
                dbImage.setSize(image.getSize());
                dbImage.setFileName(image.getOriginalFilename());
                dbImage.setListing(listing);
                imageRepository.save(dbImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
