package com.example.restapihttp.controller;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    public final UserService userService;
    @PostMapping("creat-user")
    public ResponseEntity<SignUpResponse> createUser(SignUpRequest request){
        return userService.createUsers(request);
    }

}
