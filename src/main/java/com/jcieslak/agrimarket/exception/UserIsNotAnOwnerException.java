package com.jcieslak.agrimarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UserIsNotAnOwnerException extends RuntimeException{
    public UserIsNotAnOwnerException() {
        super("User is not an owner of this resource");
    }
}
