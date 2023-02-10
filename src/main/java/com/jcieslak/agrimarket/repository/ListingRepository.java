package com.jcieslak.agrimarket.repository;

import com.jcieslak.agrimarket.model.Listing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListingRepository extends MongoRepository<Listing, String> {
}
