package com.jcieslak.agrimarket.mapper;

import com.jcieslak.agrimarket.model.Listing;
import com.jcieslak.agrimarket.model.MachineListing;
import com.jcieslak.agrimarket.payload.request.CreateListingRequest;
import com.jcieslak.agrimarket.payload.request.CreateMachineListingRequest;
import com.jcieslak.agrimarket.payload.response.ListingResponse;
import com.jcieslak.agrimarket.payload.response.MachineListingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface ListingMapper {
    ListingMapper MAPPER = Mappers.getMapper(ListingMapper.class);

    @SubclassMapping(source = CreateMachineListingRequest.class, target = MachineListing.class)
    Listing requestToEntity(CreateListingRequest createListingRequest);

    @SubclassMapping(source = MachineListing.class, target = MachineListingResponse.class)
    ListingResponse entityToResponse(Listing listing);
}
