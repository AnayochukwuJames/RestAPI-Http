package com.example.restapihttp.exception.reponse;

import lombok.*;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionResponse {


    private int status;
    private String message;
    private String path;
    private String error;
    private LocalDateTime timeStamp;

}
