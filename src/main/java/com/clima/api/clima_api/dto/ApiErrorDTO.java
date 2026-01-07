package com.clima.api.clima_api.dto;

import java.time.LocalDateTime;

public record ApiErrorDTO(
        int status,
        String message,
        LocalDateTime timestamp
) {
    public ApiErrorDTO(int status, String message){
        this(status, message, LocalDateTime.now());
    }
}
