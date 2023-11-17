package com.example.restapihttp.service;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<SignUpResponse> createUsers(SignUpRequest request);
}
