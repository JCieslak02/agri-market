package com.jcieslak.agrimarket.mapper;

import com.jcieslak.agrimarket.model.Listing;
import com.jcieslak.agrimarket.model.MachineListing;
import com.jcieslak.agrimarket.payload.request.ListingRequest;
import com.jcieslak.agrimarket.payload.request.MachineListingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface ListingMapper {
    ListingMapper MAPPER = Mappers.getMapper(ListingMapper.class);

    @SubclassMapping(source = MachineListingRequest.class, target = MachineListing.class)
    Listing requestToEntity(ListingRequest listingRequest);
}
