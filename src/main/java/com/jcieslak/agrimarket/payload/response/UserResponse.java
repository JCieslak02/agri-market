package com.jcieslak.agrimarket.payload.response;

import java.time.LocalDateTime;

public record UserResponse(String id, String firstName, LocalDateTime createdAt){}