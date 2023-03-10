package com.jcieslak.agrimarket.repository;

import com.jcieslak.agrimarket.model.Image;
import com.jcieslak.agrimarket.model.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface ImageRepository extends MongoRepository<Image, String> {
    int countAllByListing(Listing listing);
    Optional<Image> findFirstByListing(Listing listing);
}
