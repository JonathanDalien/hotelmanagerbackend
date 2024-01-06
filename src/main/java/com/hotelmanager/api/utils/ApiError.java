package com.hotelmanager.api.utils;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    // Konstruktor, Getter und Setter
}