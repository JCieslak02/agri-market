package com.jcieslak.agrimarket.payload;

import com.jcieslak.agrimarket.enums.UserRole;

public record RegisterRequest(String email, String firstName, String password, UserRole userRole){}