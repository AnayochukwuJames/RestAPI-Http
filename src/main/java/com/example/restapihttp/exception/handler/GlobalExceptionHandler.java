package com.example.restapihttp.exception.handler;

import com.example.restapihttp.exception.UserAlreadyExistException;
import com.example.restapihttp.exception.UserNotFoundException;
import com.example.restapihttp.exception.reponse.ExceptionResponse;
import com.example.restapihttp.mapper.ExceptionMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistException
            (UserAlreadyExistException e, HttpServletRequest request){
        ExceptionResponse exceptionHandler = ExceptionMapper
                .mapToExceptionResponse(e, request, HttpStatus.CONFLICT);
            return new ResponseEntity<>(exceptionHandler, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException e, HttpServletRequest request){
        ExceptionResponse exceptionResponse = ExceptionMapper
                .mapToExceptionResponse(e, request,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);

    }


}
