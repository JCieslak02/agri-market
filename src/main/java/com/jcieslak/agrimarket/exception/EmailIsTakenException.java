package com.jcieslak.agrimarket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailIsTakenException extends IllegalArgumentException{
    public EmailIsTakenException(String email) {
        super(String.format("Email %s is taken", email));
    }
}
