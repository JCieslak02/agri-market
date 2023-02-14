package com.jcieslak.agrimarket.payload.request;

import jakarta.validation.constraints.NotNull;

public record AuthenticateRequest(@NotNull String email, @NotNull String password){}
