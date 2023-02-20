package com.jcieslak.agrimarket.payload.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jcieslak.agrimarket.enums.ListingCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "listingCategory")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateMachineListingRequest.class, name = "MACHINE"),
})
@Data
public abstract class CreateListingRequest {
    @NotNull
    @Length(min = 5, max = 50)
    private String title;
    @NotNull
    private double price;
    @NotNull
    @Length(min = 5, max = 300)
    private String description;
    @NotNull
    private ListingCategory listingCategory;
    @NotNull
    private String contactPhone;
    @NotNull
    private AddressRequest addressRequest;
}
