package com.example.demojwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    private String backedMessage;
    private String message;
    private int httpCode;
    private LocalDateTime time;
}
