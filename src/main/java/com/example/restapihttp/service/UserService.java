package com.example.restapihttp.service;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.request.UpdateRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<SignUpResponse> createUsers(SignUpRequest request);

    ResponseEntity<UserResponse> getUserById(Long id);

    ResponseEntity<UserResponse> updateUser(UpdateRequest request, Long id);

    ResponseEntity<String> deleteUser(Long id);

    ResponseEntity<List<UserResponse>> getAllUser();
}
