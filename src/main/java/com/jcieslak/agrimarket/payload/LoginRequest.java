package com.jcieslak.agrimarket.payload;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String email, @NotNull String password){}
