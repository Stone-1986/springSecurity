package com.example.demojwt.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError implements Serializable {
    private String backedMessage;
    private String message;
    private String url;
    private String method;
    private int httpCode;
    private LocalDateTime timeStamp;
}
