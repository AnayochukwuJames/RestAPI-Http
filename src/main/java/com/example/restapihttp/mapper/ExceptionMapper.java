package com.example.restapihttp.mapper;

import com.example.restapihttp.exception.reponse.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionMapper {

    public static ExceptionResponse mapToExceptionResponse(Exception e, HttpServletRequest request, HttpStatus status){
       return ExceptionResponse.builder()
                .status(status.value())
                .path(request.getRequestURI())
                .message(e.getMessage())
                .error(status.name())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
