package com.jcieslak.agrimarket.payload.request;

import jakarta.validation.constraints.NotNull;

public record AddressRequest(@NotNull String placeName, @NotNull String postalCode){}
